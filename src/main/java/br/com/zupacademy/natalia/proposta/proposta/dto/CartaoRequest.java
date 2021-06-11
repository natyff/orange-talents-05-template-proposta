package br.com.zupacademy.natalia.proposta.proposta.dto;


import br.com.zupacademy.natalia.proposta.proposta.entities.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class CartaoRequest {

    @NotNull
    private String id;
    @NotNull
    private LocalDateTime emitidoEm;
    @NotBlank
    private String titular;

    private List<Bloqueios> bloqueios;

    private List<Avisos> avisos;

    private List<Carteiras> carteiras;

    private List<Parcelas> parcelas;
    private BigDecimal limite;

    private Renegociacao renegociacao;

    private Vencimento vencimento;

    private Long idProposta;



    public CartaoRequest() {
    }

    public CartaoRequest(String id, LocalDateTime emitidoEm, String titular,
                         Long idProposta, List<Bloqueios> bloqueios, List<Avisos> avisos,
                         List<Carteiras> carteiras, List<Parcelas> parcelas, BigDecimal limite,
                         Renegociacao renegociacao, Vencimento vencimento) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.idProposta = idProposta;
        this.bloqueios = bloqueios;
        this.avisos = avisos;
        this.carteiras = carteiras;
        this.parcelas = parcelas;
        this.limite = limite;
        this.renegociacao = renegociacao;
        this.vencimento = vencimento;

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

    public Long getIdProposta() {
        return idProposta;
    }



}

