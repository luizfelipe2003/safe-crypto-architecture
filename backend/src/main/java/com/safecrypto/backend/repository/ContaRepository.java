package com.safecrypto.backend.repository;

import com.safecrypto.backend.model.Conta;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContaRepository {

    private final List<Conta> contas = new ArrayList<>();

    public ContaRepository() {
        contas.add(new Conta(
                1L,
                "ACC-0001",
                "ATIVA",
                2500.00
        ));

        contas.add(new Conta(
                2L,
                "ACC-0002",
                "ATIVA",
                1800.00
        ));
    }

    public Conta buscarPorId(Long id) {
        for (Conta conta : contas) {
            if (conta.getId().equals(id)) {
                return conta;
            }
        }
        return null;
    }

    public Conta salvar(Conta conta) {
        return conta;
    }

    public List<Conta> listarTodas() {
        return contas;
    }
}