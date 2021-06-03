package br.com.zupacademy.natalia.proposta.proposta.dto;

import br.com.zupacademy.natalia.proposta.proposta.entities.Proposta;
import br.com.zupacademy.natalia.proposta.proposta.validacao.CpfOrCnpj;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class PropostaRequest {

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


    public Proposta converter() {
        return new Proposta(
                this.documento, this.email, this.nome, this.endereco, this.salario);
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
}
