package com.safecrypto.backend.repository;

import com.safecrypto.backend.model.Transacao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    private final List<Transacao> transacoes = new ArrayList<>();
    private Long proximoId = 4L;

    public TransacaoRepository() {
        transacoes.add(new Transacao(
                1L,
                1L,
                "DEPOSITO",
                1000.00,
                "2026-04-14 08:30:00",
                "CONCLUIDA"
        ));

        transacoes.add(new Transacao(
                2L,
                1L,
                "SAQUE",
                250.00,
                "2026-04-14 09:00:00",
                "CONCLUIDA"
        ));

        transacoes.add(new Transacao(
                3L,
                2L,
                "DEPOSITO",
                800.00,
                "2026-04-14 09:10:00",
                "CONCLUIDA"
        ));
    }

    public List<Transacao> buscarPorUsuarioId(Long usuarioId) {
        List<Transacao> resultado = new ArrayList<>();

        for (Transacao transacao : transacoes) {
            if (transacao.getUsuarioId().equals(usuarioId)) {
                resultado.add(transacao);
            }
        }

        return resultado;
    }

    public Transacao salvar(Transacao transacao) {
        if (transacao.getId() == null) {
            transacao.setId(proximoId++);
        }

        transacoes.add(transacao);
        return transacao;
    }

    public List<Transacao> listarTodas() {
        return transacoes;
    }
}