package br.com.zupacademy.natalia.proposta.proposta.dto;

import br.com.zupacademy.natalia.proposta.proposta.entities.Avisos;

import java.util.Date;

public class AvisosResponse {


    private Date validoAte;
    private String destino;

    public AvisosResponse(Date validoAte, String destino) {
        this.validoAte = validoAte;
        this.destino = destino;
    }

    public AvisosResponse() {
    }

    public Avisos converter(){
        return new Avisos(this.validoAte, this.destino);
    }

    public Date getValidoAte() {
        return validoAte;
    }

    public String getDestino() {
        return destino;
    }
}
