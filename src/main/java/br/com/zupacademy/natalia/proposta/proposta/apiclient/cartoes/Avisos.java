package br.com.zupacademy.natalia.proposta.proposta.apiclient.cartoes;

import java.time.LocalDate;


public class Avisos {

    private LocalDate validoAte;
    private String destino;

    public Avisos(LocalDate validoAte, String destino) {
        this.validoAte = validoAte;
        this.destino = destino;
    }

    public LocalDate getValidoAte() {
        return validoAte;
    }

    public String getDestino() {
        return destino;
    }
}
