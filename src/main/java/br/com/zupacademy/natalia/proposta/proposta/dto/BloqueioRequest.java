package br.com.zupacademy.natalia.proposta.proposta.dto;

import br.com.zupacademy.natalia.proposta.proposta.entities.Bloqueios;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class BloqueioRequest {

    @NotBlank
    private String id;
    private LocalDateTime bloqueadoEm = LocalDateTime.now();
    private String sistemaResponsavel;
    private boolean ativo;
    private String ip;

    public String getId() {
        return id;
    }

    public LocalDateTime getBloqueadoEm() {
        return bloqueadoEm;
    }

    public String getSistemaResponsavel() {
        return sistemaResponsavel;
    }

    public boolean isAtivo() {
        return ativo;
    }


    public BloqueioRequest() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBloqueadoEm(LocalDateTime bloqueadoEm) {
        this.bloqueadoEm = bloqueadoEm;
    }

    public void setSistemaResponsavel(String sistemaResponsavel) {
        this.sistemaResponsavel = sistemaResponsavel;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Bloqueios converter() {
        return new Bloqueios(this.id, this.bloqueadoEm, this.sistemaResponsavel, this.ativo, this.ip);
    }
}