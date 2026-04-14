package com.safecrypto.backend.service;

import com.safecrypto.backend.dto.SaldoResponse;
import com.safecrypto.backend.model.Conta;
import com.safecrypto.backend.model.Usuario;
import com.safecrypto.backend.repository.ContaRepository;
import com.safecrypto.backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    private final ContaRepository contaRepository;
    private final UsuarioRepository usuarioRepository;

    public ContaService(ContaRepository contaRepository, UsuarioRepository usuarioRepository) {
        this.contaRepository = contaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public SaldoResponse consultarSaldo(Long usuarioId) {
        Usuario usuario = buscarUsuarioPorId(usuarioId);
        Conta conta = contaRepository.buscarPorId(usuarioId);

        if (usuario == null || conta == null) {
            return null;
        }

        return new SaldoResponse(
                usuario.getNome(),
                conta.getNumeroConta(),
                conta.getStatusConta(),
                conta.getSaldo()
        );
    }

    private Usuario buscarUsuarioPorId(Long usuarioId) {
        for (Usuario usuario : usuarioRepository.listarTodos()) {
            if (usuario.getId().equals(usuarioId)) {
                return usuario;
            }
        }
        return null;
    }
}