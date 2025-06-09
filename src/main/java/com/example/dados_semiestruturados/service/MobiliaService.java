package com.example.dados_semiestruturados.service;

import com.example.dados_semiestruturados.entity.Livro;
import com.example.dados_semiestruturados.entity.Mobilia;
import com.example.dados_semiestruturados.entity.Patrimonio;
import com.example.dados_semiestruturados.repository.MobiliaRepository;
import com.example.dados_semiestruturados.repository.PatrimonioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobiliaService {

    @Autowired
    private PatrimonioRepository patrimonioRepository;

    @Autowired
    private MobiliaRepository mobiliaRepository;

    public void mobiliaDoCampus() {
        List<String> palavrasChave = List.of(
                "CADEIRA", "ARMARIO", "MESA", "BANQUET", "RACK"
        );

        List<Patrimonio> mobiliaPatrimonios = patrimonioRepository.findAll().stream()
                .filter(p -> {
                    String desc = p.getDescricao() != null ? p.getDescricao().toUpperCase() : "";
                    return palavrasChave.stream().anyMatch(desc::contains);
                })
                .toList();

        for (Patrimonio p : mobiliaPatrimonios) {
            boolean jaExiste = mobiliaRepository.existsByNumero(p.getNumero());
            if (!jaExiste) {
                Mobilia mobilia = new Mobilia();
                mobilia.setNumero(p.getNumero());
                mobilia.setDescricao(p.getDescricao());
                mobilia.setSituacao(p.getSituacao());
                mobilia.setEstadoConservacao(p.getEstadoConservacao());
                mobilia.setValorInicial(p.getValorInicial());
                mobilia.setValorLiquidoContabil(p.getValorLiquidoContabil());
                mobilia.setCampus(p.getCampus());

                mobiliaRepository.save(mobilia);
            }
        }
    }
}