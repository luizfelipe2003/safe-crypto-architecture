package com.safecrypto.backend.model;

public class Conta {

    private Long id;
    private String numeroConta;
    private String statusConta;
    private Double saldo;

    public Conta() {
    }

    public Conta(Long id, String numeroConta, String statusConta, Double saldo) {
        this.id = id;
        this.numeroConta = numeroConta;
        this.statusConta = statusConta;
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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