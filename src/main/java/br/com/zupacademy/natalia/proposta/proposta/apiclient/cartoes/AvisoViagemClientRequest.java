package br.com.zupacademy.natalia.proposta.proposta.apiclient.cartoes;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AvisoViagemClientRequest {

    private String destino;
    private LocalDate validoAte;


    public AvisoViagemClientRequest() {
    }

    public AvisoViagemClientRequest(String destino, LocalDate validoAte) {
        this.destino = destino;
        this.validoAte = validoAte;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDate getValidoAte() {
        return validoAte;
    }
}
