package br.com.zupacademy.natalia.proposta.proposta.apiclient.cartoes;

import org.springframework.stereotype.Component;

@Component
public class CarteirasClientRequest {

    private String email;
    private String carteira;

    public CarteirasClientRequest(String email, String carteira) {
        this.email = email;
        this.carteira = carteira;
    }

    public CarteirasClientRequest() {
    }

    public String getEmail() {
        return email;
    }

    public String getCarteira() {
        return carteira;
    }
}
