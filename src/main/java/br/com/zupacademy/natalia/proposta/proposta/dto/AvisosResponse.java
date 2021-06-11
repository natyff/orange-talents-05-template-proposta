package br.com.zupacademy.natalia.proposta.proposta.dto;

import br.com.zupacademy.natalia.proposta.proposta.entities.Avisos;

import java.time.LocalDate;

public class AvisosResponse {


    private LocalDate validoAte;
    private String destino;

    public AvisosResponse(LocalDate validoAte, String destino) {
        this.validoAte = validoAte;
        this.destino = destino;
    }

    public AvisosResponse() {
    }

    public Avisos converter(){
        return new Avisos(this.validoAte, this.destino);
    }

    public LocalDate getValidoAte() {
        return validoAte;
    }

    public String getDestino() {
        return destino;
    }
}
