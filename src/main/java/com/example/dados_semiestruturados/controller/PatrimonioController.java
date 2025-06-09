package com.example.dados_semiestruturados.controller;

import com.example.dados_semiestruturados.entity.Patrimonio;
import com.example.dados_semiestruturados.service.PatrimonioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/patrimonios")
public class PatrimonioController {

    @Autowired
    private PatrimonioService patrimonioService;

    @GetMapping("/importar")
    public ResponseEntity<String> importarArquivoLocal(@RequestParam String campus) {
        try {
            patrimonioService.importarCsv(campus.toUpperCase().trim());
            return ResponseEntity.ok("Dados do campus '" + campus + "' importados com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao importar dados do campus '" + campus + "': " + e.getMessage());
        }
    }

    @GetMapping("/valor-liquido-total")
    public ResponseEntity<String> calcularValorLiquidoTotal(@RequestParam String campus) {
        try {
            BigDecimal total = patrimonioService.calcularValorTotalLiquidoPorCampus(campus.toUpperCase().trim());
            return ResponseEntity.ok("Valor líquido contábil total do campus '" + campus + "': R$ " + total);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao calcular o valor líquido contábil: " + e.getMessage());
        }
    }
}