package br.com.zupacademy.natalia.proposta.proposta.dto;

import br.com.zupacademy.natalia.proposta.proposta.apiclient.PropostaClientRequest;
import br.com.zupacademy.natalia.proposta.proposta.entities.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class CartaoClientResponse {

    private String id;
    private LocalDateTime emitidoEm;
    private String titular;
    private List<Bloqueios> bloqueios;
    private List<Avisos> avisos;
    private List<Carteiras> carteiras;
    private List<Parcelas> parcelas;
    private BigDecimal limite;
    private Renegociacao renegociacao;
    private Vencimento vencimento;
    private PropostaClientRequest propostaId;

    public CartaoClientResponse(String id, LocalDateTime emitidoEm, String titular,
                                List<Bloqueios> bloqueios, List<Avisos> avisos, List<Carteiras> carteiras,
                                List<Parcelas> parcelas, BigDecimal limite, Renegociacao renegociacao,
                                Vencimento vencimento, PropostaClientRequest propostaId) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.bloqueios = bloqueios;
        this.avisos = avisos;
        this.carteiras = carteiras;
        this.parcelas = parcelas;
        this.limite = limite;
        this.renegociacao = renegociacao;
        this.vencimento = vencimento;
        this.propostaId = propostaId;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getEmitidoEm() {
        return emitidoEm;
    }

    public String getTitular() {
        return titular;
    }

    public List<Bloqueios> getBloqueios() {
        return bloqueios;
    }

    public List<Avisos> getAvisos() {
        return avisos;
    }

    public List<Carteiras> getCarteiras() {
        return carteiras;
    }

    public List<Parcelas> getParcelas() {
        return parcelas;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public Renegociacao getRenegociacao() {
        return renegociacao;
    }

    public Vencimento getVencimento() {
        return vencimento;
    }

    public PropostaClientRequest getPropostaId() {
        return propostaId;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Cartao converter(CartaoClientResponse cartaoClientResponse){
        return new Cartao(
                this.id,
        this.emitidoEm,
        this.titular,
        this.bloqueios,
        this.avisos,
        this.carteiras,
        this.parcelas,
        this.limite,
        this.renegociacao,
        this.vencimento,
        this.propostaId);
    }

}
