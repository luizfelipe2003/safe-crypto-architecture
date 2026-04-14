package com.safecrypto.backend.dto;

public class SaldoResponse {

    private String nomeUsuario;
    private String numeroConta;
    private String statusConta;
    private Double saldo;

    public SaldoResponse() {
    }

    public SaldoResponse(String nomeUsuario, String numeroConta, String statusConta, Double saldo) {
        this.nomeUsuario = nomeUsuario;
        this.numeroConta = numeroConta;
        this.statusConta = statusConta;
        this.saldo = saldo;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(String statusConta) {
        this.statusConta = statusConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}