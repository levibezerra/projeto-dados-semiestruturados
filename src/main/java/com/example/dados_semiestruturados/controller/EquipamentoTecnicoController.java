package com.example.dados_semiestruturados.controller;

import com.example.dados_semiestruturados.service.EquipamentoTecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tecnico")
public class EquipamentoTecnicoController {

    @Autowired
    private EquipamentoTecnicoService equipamentoTecnicoService;

    @GetMapping("/separar")
    public ResponseEntity<String> separarEquipamentoTecnico() {
        try {
            equipamentoTecnicoService.equipamentoTecnicoDoCampus();
            return ResponseEntity.ok("Equipamentos Tecnicos separados e salvos na tabela 'equipamentos_tecnico' com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao separar os Equipamentos Tecnicos: " + e.getMessage());
        }
    }
}