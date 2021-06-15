package br.com.zupacademy.natalia.proposta.proposta.entities;

import br.com.zupacademy.natalia.proposta.proposta.dto.BloqueioRequest;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Bloqueios {


    @Id
    private String id;
    @NotNull
    private LocalDateTime bloqueadoEm;
    @NotNull
    private String sistemaResponsavel;
    @NotNull
    private boolean ativo;
    @NotNull
    private String ip;


    public Bloqueios(String id, LocalDateTime bloqueadoEm, String sistemaResponsavel, boolean ativo, String ip) {
        this.id = id;
        this.bloqueadoEm = bloqueadoEm;
        this.sistemaResponsavel = sistemaResponsavel;
        this.ativo = ativo;
        this.ip = ip;
    }

    public Bloqueios(HttpServletRequest request, String sistemaResponsavel) {
        this.sistemaResponsavel = sistemaResponsavel;
    }


    public Bloqueios(BloqueioRequest bloqueioRequest) {
        this.id = bloqueioRequest.getId();
        this.bloqueadoEm = bloqueioRequest.getBloqueadoEm();
        this.sistemaResponsavel = bloqueioRequest.getSistemaResponsavel();

    }

    public Bloqueios() {
    }

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
}
