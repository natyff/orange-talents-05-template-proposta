package br.com.zupacademy.natalia.proposta.proposta.dto;

import br.com.zupacademy.natalia.proposta.proposta.entities.Carteiras;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


public class CarteirasRequest {


    @NotBlank
    @Email
    private String email;
    private String emissor;
    private String cartaoId;



    public CarteirasRequest() {
    }

    public CarteirasRequest(String email, String emissor, String cartaoId) {
        this.email = email;
        this.emissor = emissor;
        this.cartaoId = cartaoId;
    }

    public String getCartaoId() {
        return cartaoId;
    }

    public String getEmail() {
        return email;
    }

    public String getEmissor() {
        return emissor;
    }

    public void setCartaoId(String cartaoId) {
        this.cartaoId = cartaoId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmissor(String emissor) {
        this.emissor = emissor;
    }

    public Carteiras converter() {
        return new Carteiras(this.email, this.emissor, this.cartaoId);
    }
}
