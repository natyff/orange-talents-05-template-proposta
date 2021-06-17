package br.com.zupacademy.natalia.proposta.proposta.apiclient.cartoes.interfaces;

import br.com.zupacademy.natalia.proposta.proposta.apiclient.cartoes.CarteirasClientRequest;
import br.com.zupacademy.natalia.proposta.proposta.dto.CarteirasResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name = "carteiras", url = "http://localhost:8888")
public interface CarteirasClient {

    @PostMapping("/api/cartoes/{id}/avisos")
    CarteirasResponse carteiras(@PathVariable String id, CarteirasClientRequest carteirasClientRequest);

}
