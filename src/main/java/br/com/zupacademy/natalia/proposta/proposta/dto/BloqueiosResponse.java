package br.com.zupacademy.natalia.proposta.proposta.dto;

import br.com.zupacademy.natalia.proposta.proposta.enums.StatusCartao;


public class BloqueiosResponse {

    private StatusCartao statusCartao;

    public BloqueiosResponse(StatusCartao statusCartao) {
        this.statusCartao = statusCartao;
    }

    public StatusCartao getStatusCartao() {
        return statusCartao;
    }
}
