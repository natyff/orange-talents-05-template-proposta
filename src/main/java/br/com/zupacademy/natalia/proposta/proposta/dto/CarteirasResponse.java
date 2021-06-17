package br.com.zupacademy.natalia.proposta.proposta.dto;

import br.com.zupacademy.natalia.proposta.proposta.enums.StatusCarteira;

import java.time.LocalDateTime;

public class CarteirasResponse {

    private String id;
    private String email;
    private LocalDateTime associadaEm;
    private String emissor;
    private StatusCarteira statusCarteira;

    public CarteirasResponse(String id, String email, LocalDateTime associadaEm, String emissor) {
        this.id = id;
        this.email = email;
        this.associadaEm = associadaEm;
        this.emissor = emissor;
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

    public StatusCarteira getStatusCarteira() {
        return statusCarteira;
    }
}
