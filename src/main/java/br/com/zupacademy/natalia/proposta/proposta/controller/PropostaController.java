package br.com.zupacademy.natalia.proposta.proposta.controller;


import br.com.zupacademy.natalia.proposta.proposta.repositories.PropostaRepository;
import br.com.zupacademy.natalia.proposta.proposta.dto.PropostaRequest;
import br.com.zupacademy.natalia.proposta.proposta.entities.Proposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class PropostaController {

    @Autowired
    PropostaRepository propostaRepository;

    @PostMapping("/proposta")
    public ResponseEntity<String> novaProposta(@RequestBody @Valid PropostaRequest propostaRequest,
                                               UriComponentsBuilder builder){
        Proposta proposta =propostaRequest.converter();
        propostaRepository.save(proposta);

        URI urlNovaProposta = builder.path("/proposta/{id}").build(proposta.getId());
        return ResponseEntity.created(urlNovaProposta).build();
    }
}
