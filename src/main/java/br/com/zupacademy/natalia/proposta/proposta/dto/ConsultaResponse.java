package br.com.zupacademy.natalia.proposta.proposta.dto;


import br.com.zupacademy.natalia.proposta.proposta.enums.StatusProposta;

public class ConsultaResponse {

    private StatusProposta status;

    public ConsultaResponse(StatusProposta status) {
        this.status = status;
    }

    public ConsultaResponse() {
    }

    public StatusProposta getStatus() {
        return status;
    }
}
