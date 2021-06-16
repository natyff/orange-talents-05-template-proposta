package br.com.zupacademy.natalia.proposta.proposta.entities;

import br.com.zupacademy.natalia.proposta.proposta.dto.AvisoRequest;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Avisos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @FutureOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date validoAte;
    @NotBlank
    private String destino;
    @NotNull
    private LocalDateTime instanteAviso = LocalDateTime.now();
    @NotBlank
    private String ip;
    @NotBlank
    private String userAgent;

    public Avisos(Date validoAte, String destino) {
        this.validoAte = validoAte;
        this.destino = destino;
    }

    public Avisos() {
    }

    public Avisos(Date validoAte, String destino, LocalDateTime instanteAviso, String ip, String userAgent) {
        this.validoAte = validoAte;
        this.destino = destino;
        this.instanteAviso = instanteAviso;
        this.ip = ip;
        this.userAgent = userAgent;
    }

    public Avisos(AvisoRequest avisoRequest) {
        this.validoAte = avisoRequest.getValidoAte();
        this.destino = avisoRequest.getDestino();
        this.instanteAviso = avisoRequest.getInstanteAviso();
        this.ip = avisoRequest.getIp();
        this.userAgent = avisoRequest.getUserAgent();
    }

    public Long getId() {
        return id;
    }

    public Date getValidoAte() {
        return validoAte;
    }

    public String getDestino() {
        return destino;
    }
}
