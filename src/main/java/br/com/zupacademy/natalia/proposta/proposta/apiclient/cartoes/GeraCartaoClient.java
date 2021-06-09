package br.com.zupacademy.natalia.proposta.proposta.apiclient.cartoes;


import br.com.zupacademy.natalia.proposta.proposta.apiclient.PropostaClientRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cartao-id", url = "http://localhost:8888")
public interface GeraCartaoClient {

    @GetMapping("/api/cartoes?{idProposta=}")
    CartaoClientResponse enviaDadosParaNovoCartao (@PathVariable Long idProposta);

}
