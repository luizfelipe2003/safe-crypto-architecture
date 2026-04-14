package com.safecrypto.backend.controller;

import com.safecrypto.backend.dto.SaldoResponse;
import com.safecrypto.backend.service.ContaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping("/saldo/{usuarioId}")
    public ResponseEntity<SaldoResponse> consultarSaldo(@PathVariable Long usuarioId) {
        SaldoResponse response = contaService.consultarSaldo(usuarioId);

        if (response == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(response);
    }
}