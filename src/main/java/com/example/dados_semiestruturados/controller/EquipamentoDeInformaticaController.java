package com.example.dados_semiestruturados.controller;

import com.example.dados_semiestruturados.service.EquipamentoDeInformaticaService;
import com.example.dados_semiestruturados.service.MobiliaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/informatica")
public class EquipamentoDeInformaticaController {

    @Autowired
    private EquipamentoDeInformaticaService informaticaService;

    @GetMapping("/separar")
    public ResponseEntity<String> separarEquipamentosDeInformatica() {
        try {
            informaticaService.equipamentoDeInformaticaDoCampus();
            return ResponseEntity.ok("Equipamentos de Informatica separados e salvos na tabela 'equipamentos_de_informatica' com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao separar os Equipamentos de Informatica: " + e.getMessage());
        }
    }
}