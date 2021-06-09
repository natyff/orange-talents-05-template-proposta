package br.com.zupacademy.natalia.proposta.proposta.apiclient.cartoes;

import java.time.LocalDateTime;

public class Renegociacao {

    private String id;
    private Integer quantidade;
    private Integer valor;
    private LocalDateTime dataDeCriacao;


    public String getId() {
        return id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Integer getValor() {
        return valor;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }
}
