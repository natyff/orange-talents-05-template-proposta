package br.com.zupacademy.natalia.proposta.proposta.controller;

import br.com.zupacademy.natalia.proposta.proposta.apiclient.SolicitacaoClient;
import br.com.zupacademy.natalia.proposta.proposta.apiclient.PropostaClientRequest;
import br.com.zupacademy.natalia.proposta.proposta.dto.ConsultaResponse;
import br.com.zupacademy.natalia.proposta.proposta.uteis.StatusProposta;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulta")
public class ConsultaDadosController {

    @Autowired
    SolicitacaoClient solicitacaoClient;

    @PostMapping
    public ResponseEntity<ConsultaResponse> consulta(@RequestBody PropostaClientRequest request) {

        try {
             solicitacaoClient.enviarDocumento(request);
             return  ResponseEntity.ok().body(new ConsultaResponse(StatusProposta.ELEGIVEL));
        }catch (FeignException ex){
            if (ex.status() == 422) {
                return ResponseEntity.badRequest().body(new ConsultaResponse(StatusProposta.NAO_ELEGIVEL));
            }else
                throw ex;
        }
    }
}
