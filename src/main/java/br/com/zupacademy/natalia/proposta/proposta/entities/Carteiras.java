package br.com.zupacademy.natalia.proposta.proposta.entities;

import br.com.zupacademy.natalia.proposta.proposta.dto.CarteirasRequest;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Carteiras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String email;
    private LocalDateTime associadaEm = LocalDateTime.now();
    private String emissor;
    private String cartaoId;



    public Carteiras(Long id, String email, LocalDateTime associadaEm, String emissor) {
        this.id = id;
        this.email = email;
        this.associadaEm = associadaEm;
        this.emissor = emissor;

    }

    public Carteiras(String email, String emissor, String cartaoId) {
        this.email = email;
        this.emissor = emissor;
        this.cartaoId = cartaoId;
    }

    public Carteiras(CarteirasRequest carteirasRequest) {
        this.email = carteirasRequest.getEmail();
        this.emissor = carteirasRequest.getEmissor();
        this.cartaoId = carteirasRequest.getCartaoId();
    }

    public Carteiras() {
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getAssociadaEm() {
        return associadaEm;
    }

    public String getEmissor() {
        return emissor;
    }

}
