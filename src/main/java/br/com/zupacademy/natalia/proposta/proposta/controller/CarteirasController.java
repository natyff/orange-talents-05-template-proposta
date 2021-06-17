package br.com.zupacademy.natalia.proposta.proposta.controller;

import br.com.zupacademy.natalia.proposta.proposta.apiclient.cartoes.interfaces.CarteirasClient;
import br.com.zupacademy.natalia.proposta.proposta.dto.CarteirasRequest;
import br.com.zupacademy.natalia.proposta.proposta.entities.Cartao;
import br.com.zupacademy.natalia.proposta.proposta.entities.Carteiras;
import br.com.zupacademy.natalia.proposta.proposta.enums.StatusCarteira;
import br.com.zupacademy.natalia.proposta.proposta.repositories.CartaoRepository;
import br.com.zupacademy.natalia.proposta.proposta.repositories.CarteirasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
public class CarteirasController {

    @Autowired
    CarteirasRepository carteirasRepository;

    @Autowired
    CartaoRepository cartaoRepository;

    @Autowired
    CarteirasClient carteirasClient;

    @PostMapping("cartoes/{id}/carteiras")
    public ResponseEntity<String> carteira(@PathVariable String id,
                                           @Valid @RequestBody CarteirasRequest carteirasRequest,
                                           UriComponentsBuilder builder){
        Optional<Cartao> cartao = cartaoRepository.findById(id);
        if (cartao.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cartão não encontrado");
        }

        if(!cartao.get().getCarteiras().isEmpty()){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Essa carteira já existe");
        }

        cartao.get().setStatusCarteira(StatusCarteira.ASSOCIADA);
        carteirasRequest.setCartaoId(id);
        carteirasRequest.setEmail(carteirasRequest.getEmail());
        carteirasRequest.setEmissor(carteirasRequest.getEmissor());
        cartao.get().getCarteiras().add(new Carteiras(carteirasRequest));
        Carteiras carteiras = carteirasRequest.converter();
        carteirasRepository.save(carteiras);
        URI urlNovaCarteira = builder.path("/carteira/{id}").build(carteiras.getId());
        return ResponseEntity.created(urlNovaCarteira).build();
    }

}
