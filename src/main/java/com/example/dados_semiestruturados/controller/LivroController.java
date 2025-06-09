package com.example.dados_semiestruturados.controller;

import com.example.dados_semiestruturados.dto.LivroDto;
import com.example.dados_semiestruturados.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/separar")
    public ResponseEntity<String> separarLivros() {
        try {
            livroService.livroDoCampus();
            return ResponseEntity.ok("Livros separados e salvos na tabela 'livro' com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao separar livros: " + e.getMessage());
        }
    }
}