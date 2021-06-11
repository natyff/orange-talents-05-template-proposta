package br.com.zupacademy.natalia.proposta.proposta.biometria;

import br.com.zupacademy.natalia.proposta.proposta.entities.Cartao;

import javax.persistence.*;


@Entity
public class Biometria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "text")
    private String biometriaImg;
    @ManyToOne
    private Cartao cartao; // verificar


    public Biometria() {
    }


    public Biometria(String biometriaImg, Cartao cartao) {
        this.biometriaImg = biometriaImg;
        this.cartao = cartao;
    }

    public Biometria(String biometriaImg) {
        this.biometriaImg = biometriaImg;
    }

    public Long getId() {
        return id;
    }

    public String getBiometriaImg() {
        return biometriaImg;
    }

    public Cartao getCartao() {
        return cartao;
    }
}
