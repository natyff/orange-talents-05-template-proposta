package br.com.zupacademy.natalia.proposta.proposta.apiclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name = "solicitacoes", url = "http://localhost:9999")
public interface SolicitacaoClient {

    @PostMapping("/api/solicitacao")
    PropostaClienteResponse enviarDocumento(PropostaClientRequest request);
}