package br.com.zupacademy.natalia.proposta.proposta.apiclient.cartoes;


import org.springframework.stereotype.Component;

@Component
public class BloqueioClientRequest {

    private String sistemaResponsavel;

    public BloqueioClientRequest(String sistemaResponsavel) {
        this.sistemaResponsavel = sistemaResponsavel;
    }

    public String getSistemaResponsavel() {
        return sistemaResponsavel;
    }

    public BloqueioClientRequest() {
    }

}
