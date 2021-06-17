package br.com.zupacademy.natalia.proposta.proposta.controller;

import br.com.zupacademy.natalia.proposta.proposta.dto.AvisoRequest;
import br.com.zupacademy.natalia.proposta.proposta.entities.Avisos;
import br.com.zupacademy.natalia.proposta.proposta.entities.Cartao;
import br.com.zupacademy.natalia.proposta.proposta.repositories.AvisoRepository;
import br.com.zupacademy.natalia.proposta.proposta.repositories.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@RestController
public class AvisoController {

    @Autowired
    CartaoRepository cartaoRepository;

    @Autowired
    AvisoRepository avisoRepository;

    @PostMapping("/cartoes/{id}/avisos")
    public ResponseEntity<String> avisoViagem(@PathVariable String id, @Valid @RequestBody AvisoRequest avisoRequest,
                                              HttpServletRequest httpServletRequest) {
        Optional<Cartao> cartao = cartaoRepository.findById(id);
        if (cartao.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cartão não encontrado");
        }


        String ip = httpServletRequest.getRemoteAddr();
        String userAgent = httpServletRequest.getHeader("User-Agent");
        avisoRequest.getValidoAte();
        avisoRequest.getDestino();
        avisoRequest.setIp(ip);
        avisoRequest.setUserAgent(userAgent);
        cartao.get().getAvisos().add(new Avisos(avisoRequest));
        Avisos avisos = avisoRequest.converter();
        avisoRepository.save(avisos);

        return ResponseEntity.ok().body("Aviso de viagem incluída com sucesso!");
    }
}
