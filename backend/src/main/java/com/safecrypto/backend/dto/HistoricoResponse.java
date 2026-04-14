package com.safecrypto.backend.dto;

public class HistoricoResponse {

    private Long idTransacao;
    private String tipo;
    private Double valor;
    private String dataHora;
    private String status;

    public HistoricoResponse() {
    }

    public HistoricoResponse(Long idTransacao, String tipo, Double valor, String dataHora, String status) {
        this.idTransacao = idTransacao;
        this.tipo = tipo;
        this.valor = valor;
        this.dataHora = dataHora;
        this.status = status;
    }

    public Long getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Long idTransacao) {
        this.idTransacao = idTransacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}