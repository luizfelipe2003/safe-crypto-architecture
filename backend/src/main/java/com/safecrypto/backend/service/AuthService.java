package com.safecrypto.backend.service;

import com.safecrypto.backend.dto.LoginRequest;
import com.safecrypto.backend.dto.LoginResponse;
import com.safecrypto.backend.model.Usuario;
import com.safecrypto.backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;

    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public LoginResponse autenticar(LoginRequest request) {
        Usuario usuario = usuarioRepository.buscarPorEmail(request.getEmail());

        if (usuario == null) {
            return new LoginResponse(false, "Usuário não encontrado", null);
        }

        if (!usuario.getStatus().equalsIgnoreCase("ATIVO")) {
            return new LoginResponse(false, "Usuário inativo", null);
        }

        if (!usuario.getSenha().equals(request.getSenha())) {
            return new LoginResponse(false, "Senha inválida", null);
        }

        if (!usuario.getMfaCode().equals(request.getMfaCode())) {
            return new LoginResponse(false, "Código MFA inválido", null);
        }

        return new LoginResponse(true, "Login realizado com sucesso", usuario.getNome());
    }
}