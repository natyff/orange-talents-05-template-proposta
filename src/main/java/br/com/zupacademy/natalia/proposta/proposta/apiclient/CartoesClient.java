package br.com.zupacademy.natalia.proposta.proposta.apiclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name = "cartoes", url = "http://localhost:9999")
public interface CartoesClient {

    @PostMapping("/api/solicitacao")
    PropostaClienteResponse enviarDocumento(PropostaClientRequest request);
}