package br.com.zupacademy.natalia.proposta.proposta.entities;

import br.com.zupacademy.natalia.proposta.proposta.apiclient.PropostaClientRequest;
import br.com.zupacademy.natalia.proposta.proposta.biometria.Biometria;
import br.com.zupacademy.natalia.proposta.proposta.enums.StatusCartao;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Cartao{

    @Id
    private String id;
    @NotNull
    private LocalDateTime emitidoEm;
    @NotBlank
    private String titular;
    @OneToMany
    private List<Bloqueios> bloqueios;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Avisos> avisos;
    @OneToMany
    private List<Carteiras> carteiras;
    @OneToMany
    private List<Parcelas> parcelas;
    private BigDecimal limite;
    @ManyToOne
    private Renegociacao renegociacao;
    @ManyToOne(cascade = CascadeType.ALL)
    private Vencimento vencimento;
    @OneToOne @JoinColumn(name = "proposta_id")
    private Proposta proposta;
    @OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
    private List<Biometria> biometrias;
    @Enumerated(EnumType.STRING)
    private StatusCartao status;


    public Cartao() {
    }

    public Cartao(String id, LocalDateTime emitidoEm, String titular,
                  Proposta proposta, List<Bloqueios> bloqueios, List<Avisos> avisos,
                  List<Carteiras> carteiras, List<Parcelas> parcelas, BigDecimal limite,
                  Renegociacao renegociacao, Vencimento vencimento, List<Biometria> biometrias) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.proposta = proposta;
        this.bloqueios = bloqueios;
        this.avisos = avisos;
        this.carteiras = carteiras;
        this.parcelas = parcelas;
        this.limite = limite;
        this.renegociacao = renegociacao;
        this.vencimento = vencimento;
        this.biometrias = biometrias;
    }

    public Cartao(String id, LocalDateTime emitidoEm, String titular,
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
    }


    public Cartao associaBiometriaComCartao(List<Biometria> biometrias){
        this.biometrias.addAll(biometrias);
        return this;
    }

    public String getId() {
        return id;
    }

    public List<Biometria> getBiometrias() {
        return biometrias;
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

    public Proposta getProposta() {
        return proposta;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setBiometrias(List<Biometria> biometrias) {
        this.biometrias = biometrias;
    }

    public StatusCartao getStatus() {
        return status;
    }

    public void setStatus(StatusCartao status) {
        this.status = status;
    }
}

