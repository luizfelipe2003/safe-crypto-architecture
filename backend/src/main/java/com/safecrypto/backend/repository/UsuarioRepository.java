package com.safecrypto.backend.repository;

import com.safecrypto.backend.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {

    private final List<Usuario> usuarios = new ArrayList<>();

    public UsuarioRepository() {
        usuarios.add(new Usuario(
                1L,
                "Luiz Felipe",
                "luiz@safecrypto.com",
                "123456",
                "999999",
                "ATIVO"
        ));

        usuarios.add(new Usuario(
                2L,
                "Pedro Paulo",
                "pedro@safecrypto.com",
                "654321",
                "888888",
                "ATIVO"
        ));
    }

    public Usuario buscarPorEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equalsIgnoreCase(email)) {
                return usuario;
            }
        }
        return null;
    }

    public List<Usuario> listarTodos() {
        return usuarios;
    }
}