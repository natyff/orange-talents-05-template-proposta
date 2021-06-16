package br.com.zupacademy.natalia.proposta.proposta.dto;

import br.com.zupacademy.natalia.proposta.proposta.entities.Avisos;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

public class AvisoRequest {

    @NotNull
    @FutureOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date validoAte;
    @NotBlank
    private String destino;
    private LocalDateTime instanteAviso = LocalDateTime.now();
    private String ip;
    private String userAgent;

    public AvisoRequest() {
    }

    public Avisos converter() {
        return new Avisos (this.validoAte, this.destino, this.instanteAviso, this.ip, this.userAgent);
    }


    public Date getValidoAte() {
        return validoAte;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDateTime getInstanteAviso() {
        return instanteAviso;
    }

    public String getIp() {
        return ip;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setValidoAte(Date validoAte) {
        this.validoAte = validoAte;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setInstanteAviso(LocalDateTime instanteAviso) {
        this.instanteAviso = instanteAviso;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}
