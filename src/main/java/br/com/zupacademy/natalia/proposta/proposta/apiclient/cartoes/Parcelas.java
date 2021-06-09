package br.com.zupacademy.natalia.proposta.proposta.apiclient.cartoes;

public class Parcelas {

    private String id;
    private Integer quantidade;
    private Integer valor;

    public Parcelas(String id, Integer quantidade, Integer valor) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
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
