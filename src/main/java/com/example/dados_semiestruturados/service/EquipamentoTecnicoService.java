package com.example.dados_semiestruturados.service;

import com.example.dados_semiestruturados.entity.EquipamentoDeInformatica;
import com.example.dados_semiestruturados.entity.EquipamentoTecnico;
import com.example.dados_semiestruturados.entity.Patrimonio;
import com.example.dados_semiestruturados.repository.EquipamentoTecnicoRepository;
import com.example.dados_semiestruturados.repository.PatrimonioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoTecnicoService {

    @Autowired
    private PatrimonioRepository patrimonioRepository;

    @Autowired
    private EquipamentoTecnicoRepository equipamentoTecnicoRepository;

    public void equipamentoTecnicoDoCampus() {
        List<String> palavrasChave = List.of(
                "TACOMETRO", "MICROFONE", "PHMETRO", "TERMOMETRO", "OSCILOSCOPIO", "REFRATOMETRO", "DENSIMETRO",
                "GRAVADOR", "CAMERA", "TRIPE", "MULTIMETRO", "MÓDULO ELETRÔNICO", "CONDUTIVIMETRO", "ABSDARIO", "FORNO",
                "SERRA", "FURADEIRA", "BOMBA", "AGITADOR", "DESTILADOR", "FECHADURA"
        );

        List<Patrimonio> equipamentoTecnicoPatrimonios = patrimonioRepository.findAll().stream()
                .filter(p -> {
                    String desc = p.getDescricao() != null ? p.getDescricao().toUpperCase() : "";
                    return palavrasChave.stream().anyMatch(desc::contains);
                })
                .toList();

        for (Patrimonio p : equipamentoTecnicoPatrimonios) {
            boolean jaExiste = equipamentoTecnicoRepository.existsByNumero(p.getNumero());
            if (!jaExiste) {
                EquipamentoTecnico equipamentoTecnico = new EquipamentoTecnico();
                equipamentoTecnico.setNumero(p.getNumero());
                equipamentoTecnico.setDescricao(p.getDescricao());
                equipamentoTecnico.setSituacao(p.getSituacao());
                equipamentoTecnico.setEstadoConservacao(p.getEstadoConservacao());
                equipamentoTecnico.setValorInicial(p.getValorInicial());
                equipamentoTecnico.setValorLiquidoContabil(p.getValorLiquidoContabil());
                equipamentoTecnico.setCampus(p.getCampus());

                equipamentoTecnicoRepository.save(equipamentoTecnico);
            }
        }
    }
}