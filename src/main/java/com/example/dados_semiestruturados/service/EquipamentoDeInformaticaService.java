package com.example.dados_semiestruturados.service;

import com.example.dados_semiestruturados.entity.EquipamentoDeInformatica;
import com.example.dados_semiestruturados.entity.Mobilia;
import com.example.dados_semiestruturados.entity.Patrimonio;
import com.example.dados_semiestruturados.repository.EquipamentoDeInformaticaRepository;
import com.example.dados_semiestruturados.repository.PatrimonioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoDeInformaticaService {

    @Autowired
    private PatrimonioRepository patrimonioRepository;

    @Autowired
    private EquipamentoDeInformaticaRepository equipamentoDeInformaticaRepository;

    public void equipamentoDeInformaticaDoCampus() {
        List<String> palavrasChave = List.of(
                "MICROCOMPUTADOR", "SAMSUNG", "NOTEBOOK", "MONITOR"
        );

        List<Patrimonio> equipamentoDeinfoPatrimonios = patrimonioRepository.findAll().stream()
                .filter(p -> {
                    String desc = p.getDescricao() != null ? p.getDescricao().toUpperCase() : "";
                    return palavrasChave.stream().anyMatch(desc::contains);
                })
                .toList();

        for (Patrimonio p : equipamentoDeinfoPatrimonios) {
            boolean jaExiste = equipamentoDeInformaticaRepository.existsByNumero(p.getNumero());
            if (!jaExiste) {
                EquipamentoDeInformatica equipamentoDeInformatica = new EquipamentoDeInformatica();
                equipamentoDeInformatica.setNumero(p.getNumero());
                equipamentoDeInformatica.setDescricao(p.getDescricao());
                equipamentoDeInformatica.setSituacao(p.getSituacao());
                equipamentoDeInformatica.setEstadoConservacao(p.getEstadoConservacao());
                equipamentoDeInformatica.setValorInicial(p.getValorInicial());
                equipamentoDeInformatica.setValorLiquidoContabil(p.getValorLiquidoContabil());
                equipamentoDeInformatica.setCampus(p.getCampus());

                equipamentoDeInformaticaRepository.save(equipamentoDeInformatica);
            }
        }
    }
}