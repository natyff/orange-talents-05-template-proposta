package br.com.zupacademy.natalia.proposta.proposta.biometria;


import br.com.zupacademy.natalia.proposta.proposta.entities.Cartao;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@JsonAutoDetect
public class BiometriaRequest {

    @NotNull
    private List<String> biometriaImg;


    public BiometriaRequest() {
    }

    public void setBiometriaImg(List<String> biometriaImg) {
        this.biometriaImg = biometriaImg;
    }

    public List<String> getBiometriaImg() {
        return biometriaImg;
    }



    public String verificarBiometria()
    {
        Base64.Decoder decoder = Base64.getDecoder();
        for (String b : this.biometriaImg) {
            try {
                System.out.println(b);
                decoder.decode(b);
            } catch (Exception ex) {
                System.out.println("verificar");

            }
        }
        return "nao foi possivel localizar";
    }

    @JsonCreator
    public BiometriaRequest(List<String>biometriaImg){
        this.biometriaImg = biometriaImg;
    }

    public List<Biometria> converter(Cartao cartao){
        List<Biometria> biometrias = new ArrayList<>();
        this.biometriaImg.stream().forEach(b -> biometrias.add(new Biometria(b, cartao)));
        return biometrias;
    }

}
