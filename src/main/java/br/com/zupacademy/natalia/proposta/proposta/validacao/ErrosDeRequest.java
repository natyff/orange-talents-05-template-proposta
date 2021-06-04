package br.com.zupacademy.natalia.proposta.proposta.validacao;


public class ErrosDeRequest {

    private String campo;
    private String mensagem;


    public ErrosDeRequest(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;

    }

    public ErrosDeRequest() {
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }


}
