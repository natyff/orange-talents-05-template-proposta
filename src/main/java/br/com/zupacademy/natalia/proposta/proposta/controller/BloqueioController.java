package br.com.zupacademy.natalia.proposta.proposta.controller;

import br.com.zupacademy.natalia.proposta.proposta.apiclient.cartoes.interfaces.ConsultaBloqueio;
import br.com.zupacademy.natalia.proposta.proposta.dto.BloqueioRequest;
import br.com.zupacademy.natalia.proposta.proposta.entities.Bloqueios;
import br.com.zupacademy.natalia.proposta.proposta.entities.Cartao;
import br.com.zupacademy.natalia.proposta.proposta.enums.StatusCartao;
import br.com.zupacademy.natalia.proposta.proposta.repositories.BloqueiosRepository;
import br.com.zupacademy.natalia.proposta.proposta.repositories.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
public class BloqueioController {

    @Autowired
    CartaoRepository cartaoRepository;

    @Autowired
    BloqueiosRepository bloqueiosRepository;

    @Autowired
    ConsultaBloqueio consultaBloqueio;

    @PostMapping("/cartoes/{id}/bloqueios")
    public ResponseEntity<String> bloquearCartao(@PathVariable String id, HttpServletRequest request,
                                                 BloqueioRequest bloqueioRequest) {

        Optional<Cartao> cartao = cartaoRepository.findById(id);
        if (cartao.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cartão não encontrado");
        }
        if (cartao.isPresent()
                && cartao.get().getBloqueios() != null
                && !cartao.get().getBloqueios().isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("O cartão já esta Bloqueado");
            }

            String ip = request.getRemoteAddr();
            String sistemaResponsavel = request.getHeader("User-Agent");
            cartao.get().setStatus(StatusCartao.BLOQUEADO);
            bloqueioRequest.setId(id);
            bloqueioRequest.setAtivo(true);
            bloqueioRequest.setIp(ip);
            bloqueioRequest.setSistemaResponsavel(sistemaResponsavel);
            cartao.get().getBloqueios().add(new Bloqueios(bloqueioRequest));
            Bloqueios bloqueios = bloqueioRequest.converter();
            bloqueiosRepository.save(bloqueios);

                return ResponseEntity.ok().body("Cartão Bloqueado");
    }
}
