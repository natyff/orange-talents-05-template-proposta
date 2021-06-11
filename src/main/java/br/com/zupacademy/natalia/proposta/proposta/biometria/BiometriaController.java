package br.com.zupacademy.natalia.proposta.proposta.biometria;

import br.com.zupacademy.natalia.proposta.proposta.entities.Cartao;
import br.com.zupacademy.natalia.proposta.proposta.repositories.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BiometriaController {

    @Autowired
    CartaoRepository cartaoRepository;

    @PostMapping("/cartoes/{id}/biometria")
    public ResponseEntity<?> novaBiometria(@RequestBody @Valid BiometriaRequest biometriaRequest,
                                           @PathVariable String id, UriComponentsBuilder uriComponentsBuilder){

        Optional<Cartao> cartao = cartaoRepository.findById(id);
        if(cartao.isEmpty()){
            return ResponseEntity.badRequest().body("Este cartão não existe");
        }

        Cartao cartaoBiometria = cartao.get().associaBiometriaComCartao(biometriaRequest
                .converter(cartao.get()));
        cartaoRepository.save(cartaoBiometria);

        URI uri = uriComponentsBuilder.path("/cartao/{id}/biometria").buildAndExpand(cartao
                .get()).toUri();
        return ResponseEntity.created(uri).build();

    }
}
