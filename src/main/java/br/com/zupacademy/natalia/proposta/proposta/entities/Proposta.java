package br.com.zupacademy.natalia.proposta.proposta.entities;

import br.com.zupacademy.natalia.proposta.proposta.uteis.StatusProposta;
import br.com.zupacademy.natalia.proposta.proposta.validacao.CpfOrCnpj;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @CpfOrCnpj
    private String documento;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String endereco;
    @NotNull
    @Positive
    private BigDecimal salario;
    @Enumerated(EnumType.STRING)
    private StatusProposta status;

    private String cartao;



    public Proposta(String documento, String email, String nome, String endereco, BigDecimal salario) {
        this.documento = documento;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public StatusProposta getStatus() {
        return status;
    }

    public String getCartao() {
        return cartao;
    }

    public void setStatus(StatusProposta status) {
        this.status = status;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public Proposta() {
    }

}
