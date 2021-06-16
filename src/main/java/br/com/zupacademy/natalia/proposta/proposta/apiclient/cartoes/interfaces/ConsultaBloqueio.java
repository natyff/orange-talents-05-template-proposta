package br.com.zupacademy.natalia.proposta.proposta.apiclient.cartoes.interfaces;

import br.com.zupacademy.natalia.proposta.proposta.apiclient.cartoes.BloqueioClientRequest;
import br.com.zupacademy.natalia.proposta.proposta.dto.BloqueiosResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "bloqueio-cartao", url = "http://localhost:8888")
public interface ConsultaBloqueio {

    @PostMapping("/api/cartoes/{id}/bloqueios")
    BloqueiosResponse bloqueiaCartao(@PathVariable String id, BloqueioClientRequest bloqueioClientRequest);
}
