package com.example.dados_semiestruturados.controller;

import com.example.dados_semiestruturados.service.MobiliaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mobilia")
public class MobiliaController {

    @Autowired
    private MobiliaService mobiliaService;

    @GetMapping("/separar")
    public ResponseEntity<String> separarLivros() {
        try {
            mobiliaService.mobiliaDoCampus();
            return ResponseEntity.ok("Mobilia separada e salva na tabela 'mobilia' com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao separar a mobilia: " + e.getMessage());
        }
    }
}