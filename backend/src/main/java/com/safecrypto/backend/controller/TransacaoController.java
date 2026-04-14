package com.safecrypto.backend.controller;

import com.safecrypto.backend.dto.DepositoRequest;
import com.safecrypto.backend.dto.HistoricoResponse;
import com.safecrypto.backend.dto.OperacaoResponse;
import com.safecrypto.backend.dto.SaqueRequest;
import com.safecrypto.backend.service.TransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @GetMapping("/historico/{usuarioId}")
    public ResponseEntity<List<HistoricoResponse>> consultarHistorico(@PathVariable Long usuarioId) {
        List<HistoricoResponse> historico = transacaoService.consultarHistorico(usuarioId);
        return ResponseEntity.ok(historico);
    }

    @PostMapping("/deposito")
    public ResponseEntity<OperacaoResponse> realizarDeposito(@RequestBody DepositoRequest request) {
        OperacaoResponse response = transacaoService.realizarDeposito(request.getUsuarioId(), request.getValor());

        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.badRequest().body(response);
    }

    @PostMapping("/saque")
    public ResponseEntity<OperacaoResponse> realizarSaque(@RequestBody SaqueRequest request) {
        OperacaoResponse response = transacaoService.realizarSaque(request.getUsuarioId(), request.getValor());

        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.badRequest().body(response);
    }
}