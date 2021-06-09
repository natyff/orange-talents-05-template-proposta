package br.com.zupacademy.natalia.proposta.proposta.apiclient;

import org.springframework.stereotype.Component;

@Component
public class PropostaClientRequest {

    private String documento;
    private String nome;
    private String idProposta;


    public PropostaClientRequest() {
    }

    public PropostaClientRequest(String documento, String nome, String idProposta) {
        this.documento = documento;
        this.nome = nome;
        this.idProposta = idProposta;
    }


    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public String getIdProposta() {
        return idProposta;
    }
}
