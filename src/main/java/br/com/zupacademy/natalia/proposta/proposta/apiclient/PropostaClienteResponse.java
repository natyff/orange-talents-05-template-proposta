package br.com.zupacademy.natalia.proposta.proposta.apiclient;

public class PropostaClienteResponse {

    private String documento;
    private String nome;
    private String resultadoSolicitacao;
    private String idProposta;


    public PropostaClienteResponse(String documento, String nome, String resultadoSolicitacao,String idProposta) {
        this.documento = documento;
        this.nome = nome;
        this.resultadoSolicitacao = resultadoSolicitacao;
        this.idProposta = idProposta;
    }

    public PropostaClienteResponse() {
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public String getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }

    public String getIdProposta() {
        return idProposta;
    }

}
