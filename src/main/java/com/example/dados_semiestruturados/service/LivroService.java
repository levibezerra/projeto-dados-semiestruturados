package com.example.dados_semiestruturados.service;

import com.example.dados_semiestruturados.dto.LivroDto;
import com.example.dados_semiestruturados.entity.Livro;
import com.example.dados_semiestruturados.entity.Patrimonio;
import com.example.dados_semiestruturados.repository.CampusRepositoty;
import com.example.dados_semiestruturados.repository.LivroRepository;
import com.example.dados_semiestruturados.repository.PatrimonioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private PatrimonioRepository patrimonioRepository;

    @Autowired
    private LivroRepository livroRepository;

    public void livroDoCampus() {
        List<String> palavrasChave = List.of(
                "LIVRO", "EDITORA", "ENGENHARIA", "PETRÓLEO", "GERENCIAMENTO",
                "INDÚSTRIA", "PRODUÇÃO", "INTRODUÇÃO", "SISTEMAS", "PRÁTICA", "APRENDIZAGEM",
                "PEDAGOGIA", "COMPETÊNCIAS", "SINAIS", "LÍNGUA", "METODOS", "ELETRONICA DIGITAL",
                "ALGEBRA", "ISBN"
        );

        List<Patrimonio> livrosPatrimonios = patrimonioRepository.findAll().stream()
                .filter(p -> {
                    String desc = p.getDescricao() != null ? p.getDescricao().toUpperCase() : "";
                    return palavrasChave.stream().anyMatch(desc::contains);
                })
                .toList();

        for (Patrimonio p : livrosPatrimonios) {
            boolean jaExiste = livroRepository.existsByNumero(p.getNumero());
            if (!jaExiste) {
                Livro livro = new Livro();
                livro.setNumero(p.getNumero());
                livro.setDescricao(p.getDescricao());
                livro.setSituacao(p.getSituacao());
                livro.setEstadoConservacao(p.getEstadoConservacao());
                livro.setValorInicial(p.getValorInicial());
                livro.setValorLiquidoContabil(p.getValorLiquidoContabil());
                livro.setCampus(p.getCampus());

                livroRepository.save(livro);
            }
        }
    }
}