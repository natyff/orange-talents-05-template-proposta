package br.com.zupacademy.natalia.proposta.proposta.apiclient.cartoes.interfaces;

import br.com.zupacademy.natalia.proposta.proposta.apiclient.cartoes.AvisoViagemClientRequest;
import br.com.zupacademy.natalia.proposta.proposta.dto.AvisosResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name = "aviso-viagem", url = "http://localhost:8888")
public interface AvisoViagemClient {

        @PostMapping("/api/cartoes/{id}/avisos")
        AvisosResponse avisoViagem(@PathVariable String id, AvisoViagemClientRequest avisoViagemClientRequest);
}
