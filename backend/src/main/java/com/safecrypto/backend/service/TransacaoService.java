package com.safecrypto.backend.service;

import com.safecrypto.backend.dto.HistoricoResponse;
import com.safecrypto.backend.dto.OperacaoResponse;
import com.safecrypto.backend.model.Conta;
import com.safecrypto.backend.model.Transacao;
import com.safecrypto.backend.repository.ContaRepository;
import com.safecrypto.backend.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;
    private final ContaRepository contaRepository;

    public TransacaoService(TransacaoRepository transacaoRepository, ContaRepository contaRepository) {
        this.transacaoRepository = transacaoRepository;
        this.contaRepository = contaRepository;
    }

    public List<HistoricoResponse> consultarHistorico(Long usuarioId) {
        List<Transacao> transacoes = transacaoRepository.buscarPorUsuarioId(usuarioId);
        List<HistoricoResponse> historico = new ArrayList<>();

        for (Transacao transacao : transacoes) {
            historico.add(new HistoricoResponse(
                    transacao.getId(),
                    transacao.getTipo(),
                    transacao.getValor(),
                    transacao.getDataHora(),
                    transacao.getStatus()
            ));
        }

        return historico;
    }

    public OperacaoResponse realizarDeposito(Long usuarioId, Double valor) {
        Conta conta = contaRepository.buscarPorId(usuarioId);

        if (conta == null) {
            return new OperacaoResponse(false, "Conta não encontrada", "DEPOSITO", null, false);
        }

        if (valor == null || valor <= 0) {
            return new OperacaoResponse(false, "Valor de depósito inválido", "DEPOSITO", conta.getSaldo(), false);
        }

        conta.setSaldo(conta.getSaldo() + valor);
        contaRepository.salvar(conta);

        Transacao transacao = new Transacao(
                null,
                usuarioId,
                "DEPOSITO",
                valor,
                agora(),
                "CONCLUIDA"
        );

        transacaoRepository.salvar(transacao);

        System.out.println("LOG: Depósito registrado para o usuário " + usuarioId);

        return new OperacaoResponse(
                true,
                "Depósito realizado com sucesso",
                "DEPOSITO",
                conta.getSaldo(),
                false
        );
    }

    public OperacaoResponse realizarSaque(Long usuarioId, Double valor) {
        Conta conta = contaRepository.buscarPorId(usuarioId);

        if (conta == null) {
            return new OperacaoResponse(false, "Conta não encontrada", "SAQUE", null, false);
        }

        if (valor == null || valor <= 0) {
            return new OperacaoResponse(false, "Valor de saque inválido", "SAQUE", conta.getSaldo(), false);
        }

        if (conta.getSaldo() < valor) {
            return new OperacaoResponse(false, "Saldo insuficiente", "SAQUE", conta.getSaldo(), false);
        }

        conta.setSaldo(conta.getSaldo() - valor);
        contaRepository.salvar(conta);

        Transacao transacao = new Transacao(
                null,
                usuarioId,
                "SAQUE",
                valor,
                agora(),
                "CONCLUIDA"
        );

        transacaoRepository.salvar(transacao);

        boolean alertaGerado = valor >= 1000.0;

        System.out.println("LOG: Saque registrado para o usuário " + usuarioId);

        if (alertaGerado) {
            System.out.println("ALERTA: Operação de risco detectada para o usuário " + usuarioId);
        }

        return new OperacaoResponse(
                true,
                alertaGerado ? "Saque realizado com alerta de risco" : "Saque realizado com sucesso",
                "SAQUE",
                conta.getSaldo(),
                alertaGerado
        );
    }

    private String agora() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}