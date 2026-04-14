package com.safecrypto.backend.dto;

public class OperacaoResponse {

    private boolean success;
    private String message;
    private String tipoOperacao;
    private Double saldoAtual;
    private boolean alertaGerado;

    public OperacaoResponse() {
    }

    public OperacaoResponse(boolean success, String message, String tipoOperacao, Double saldoAtual, boolean alertaGerado) {
        this.success = success;
        this.message = message;
        this.tipoOperacao = tipoOperacao;
        this.saldoAtual = saldoAtual;
        this.alertaGerado = alertaGerado;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(Double saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    public boolean isAlertaGerado() {
        return alertaGerado;
    }

    public void setAlertaGerado(boolean alertaGerado) {
        this.alertaGerado = alertaGerado;
    }
}