package br.com.zupacademy.natalia.proposta.proposta.dto;

import br.com.zupacademy.natalia.proposta.proposta.entities.Carteiras;

import java.time.LocalDateTime;

public class CarteirasResponse {

    private String id;
    private String email;
    private LocalDateTime associadaEm;
    private String emissor;

    public CarteirasResponse(String id, String email, LocalDateTime associadaEm, String emissor) {
        this.id = id;
        this.email = email;
        this.associadaEm = associadaEm;
        this.emissor = emissor;
    }
    public Carteiras converter(){
        return new Carteiras(this.id, this.email, this.associadaEm, this.emissor);
    }

    public String getId() {
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
