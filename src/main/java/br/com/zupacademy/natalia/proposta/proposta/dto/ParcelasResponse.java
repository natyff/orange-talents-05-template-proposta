package br.com.zupacademy.natalia.proposta.proposta.dto;

import br.com.zupacademy.natalia.proposta.proposta.entities.Parcelas;


public class ParcelasResponse {

    private String id;
    private Integer quantidade;
    private Integer valor;

    public ParcelasResponse(String id, Integer quantidade, Integer valor) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Parcelas converter(){
        return new Parcelas(this.id, this.quantidade, this.valor);
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
}
