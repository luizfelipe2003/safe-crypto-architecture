package com.safecrypto.backend.dto;

public class SaqueRequest {

    private Long usuarioId;
    private Double valor;

    public SaqueRequest() {
    }

    public SaqueRequest(Long usuarioId, Double valor) {
        this.usuarioId = usuarioId;
        this.valor = valor;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}