package br.com.zupacademy.natalia.proposta.proposta.controller;

import br.com.zupacademy.natalia.proposta.proposta.apiclient.PropostaClientRequest;
import br.com.zupacademy.natalia.proposta.proposta.apiclient.PropostaClienteResponse;
import br.com.zupacademy.natalia.proposta.proposta.apiclient.SolicitacaoClient;
import br.com.zupacademy.natalia.proposta.proposta.repositories.PropostaRepository;
import br.com.zupacademy.natalia.proposta.proposta.dto.PropostaRequest;
import br.com.zupacademy.natalia.proposta.proposta.entities.Proposta;
import br.com.zupacademy.natalia.proposta.proposta.enums.StatusProposta;
import feign.FeignException;
import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
public class PropostaController {

    @Autowired
    PropostaRepository propostaRepository;

    @Autowired
    SolicitacaoClient solicitacaoClient;

    private final Tracer tracer;

    public PropostaController(Tracer tracer) {
        this.tracer = tracer;
    }



    @PostMapping("/proposta")
    public ResponseEntity<String> novaProposta(@RequestBody @Valid PropostaRequest propostaRequest,
                                               UriComponentsBuilder builder){

//        Tags OpenTrancing
        Span activeSpan = tracer.activeSpan();
        activeSpan.setTag("user.aplicacao", "propostas");
        activeSpan.setBaggageItem("user.aplicacao", "propostas");
        activeSpan.log("Teste");

        //caso o cliente já tenha uma proposta em andamento retornar 422
        Optional<Proposta> jaPossuiProposta = propostaRepository.findByDocumento(propostaRequest.getDocumento());
        if(jaPossuiProposta.isPresent()){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        Proposta proposta = propostaRequest.converter();
        propostaRepository.save(proposta);

        PropostaClientRequest propostaClientRequest = new PropostaClientRequest(
                propostaRequest.getDocumento(),
                propostaRequest.getNome(),
                proposta.getId().toString()
        );
        try {
            solicitacaoClient.enviarDocumento(propostaClientRequest);
            PropostaClienteResponse propostaClienteResponse = solicitacaoClient.enviarDocumento(propostaClientRequest);
            if(propostaClienteResponse.getResultadoSolicitacao().equals("SEM_RESTRICAO")){
            proposta.setStatus(StatusProposta.ELEGIVEL);
        }
        }catch (FeignException ex){
            if (ex.status() == 422) {
                proposta.setStatus(StatusProposta.NAO_ELEGIVEL);
                propostaRepository.save(proposta);
                return ResponseEntity.badRequest().body("Infelizmente não foi possível emitir uma nova proposta");
            }else
                throw ex;
        }

        propostaRepository.save(proposta);

        URI urlNovaProposta = builder.path("/proposta/{id}").build(proposta.getId());
        return ResponseEntity.created(urlNovaProposta).build();
    }

    @GetMapping("/proposta/{id}")
    public ResponseEntity<PropostaClienteResponse> mostraProposta(@PathVariable Long id){
        Optional<Proposta> propostaId = propostaRepository.findById(id);
        if(propostaId.isPresent()) {
            return ResponseEntity.ok().body(new PropostaClienteResponse(propostaId.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
