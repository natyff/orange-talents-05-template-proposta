package br.com.zupacademy.natalia.proposta.proposta.dto;

import java.time.LocalDateTime;


public class RenegociacaoResponse {

    private String id;
    private Integer quantidade;
    private Integer valor;
    private LocalDateTime dataDeCriacao;

    public RenegociacaoResponse(String id, Integer quantidade, Integer valor, LocalDateTime dataDeCriacao) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
        this.dataDeCriacao = dataDeCriacao;
    }

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
