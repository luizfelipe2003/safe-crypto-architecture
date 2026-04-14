package com.safecrypto.backend.dto;

public class LoginResponse {

    private boolean success;
    private String message;
    private String nomeUsuario;

    public LoginResponse() {
    }

    public LoginResponse(boolean success, String message, String nomeUsuario) {
        this.success = success;
        this.message = message;
        this.nomeUsuario = nomeUsuario;
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

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}