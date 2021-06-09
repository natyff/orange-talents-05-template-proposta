package br.com.zupacademy.natalia.proposta.proposta.controller;


import br.com.zupacademy.natalia.proposta.proposta.apiclient.cartoes.CartaoClientResponse;
import br.com.zupacademy.natalia.proposta.proposta.apiclient.cartoes.GeraCartaoClient;
import br.com.zupacademy.natalia.proposta.proposta.apiclient.PropostaClientRequest;
import br.com.zupacademy.natalia.proposta.proposta.apiclient.PropostaClienteResponse;
import br.com.zupacademy.natalia.proposta.proposta.apiclient.SolicitacaoClient;
import br.com.zupacademy.natalia.proposta.proposta.dto.ConsultaResponse;
import br.com.zupacademy.natalia.proposta.proposta.repositories.PropostaRepository;
import br.com.zupacademy.natalia.proposta.proposta.dto.PropostaRequest;
import br.com.zupacademy.natalia.proposta.proposta.entities.Proposta;
import br.com.zupacademy.natalia.proposta.proposta.schedule.ConsultaCartao;
import br.com.zupacademy.natalia.proposta.proposta.uteis.StatusProposta;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
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


    @Autowired
    ConsultaCartao consultaCartao;


    @PostMapping("/proposta")
    public ResponseEntity<String> novaProposta(@RequestBody @Valid PropostaRequest propostaRequest,
                                               UriComponentsBuilder builder){
        //caso o cliente já tenha uma proposta em andamento retornar 422
        Optional<Proposta> jaPossuiProposta = propostaRepository.findByDocumento(propostaRequest.getDocumento());
        if(jaPossuiProposta.isPresent()){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        Proposta proposta = propostaRequest.converter();
        propostaRepository.save(proposta);

        PropostaClientRequest propostaClientRequest = new PropostaClientRequest(
                propostaRequest.getNome(),
                propostaRequest.getDocumento(),
                proposta.getId().toString()
        );





        solicitacaoClient.enviarDocumento(propostaClientRequest);
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
