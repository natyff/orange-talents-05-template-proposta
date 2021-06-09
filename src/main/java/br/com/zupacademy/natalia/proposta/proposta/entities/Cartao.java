package br.com.zupacademy.natalia.proposta.proposta.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String numeroCartao;

    @NotNull
    private LocalDateTime dataEmissao;
    @NotBlank
    private String nomeTitular;
    @NotNull
    @OneToOne
    private Proposta proposta;

    public Cartao() {
    }

    public Cartao(Long id, String numeroCartao, LocalDateTime dataEmissao, String nomeTitular, Proposta proposta) {
        this.id = id;
        this.numeroCartao = numeroCartao;
        this.dataEmissao = dataEmissao;
        this.nomeTitular = nomeTitular;
        this.proposta = proposta;
    }


    public Long getId() {
        return id;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public LocalDateTime getDataEmissao() {
        return dataEmissao;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public Proposta getProposta() {
        return proposta;
    }

}

