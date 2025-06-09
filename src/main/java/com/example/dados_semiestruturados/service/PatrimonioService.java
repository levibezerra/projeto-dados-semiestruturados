package com.example.dados_semiestruturados.service;

import com.example.dados_semiestruturados.dto.PatrimonioDto;
import com.example.dados_semiestruturados.entity.Campus;
import com.example.dados_semiestruturados.entity.Patrimonio;
import com.example.dados_semiestruturados.repository.CampusRepositoty;
import com.example.dados_semiestruturados.repository.PatrimonioRepository;
import com.example.dados_semiestruturados.util.TratamentoDeDados;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;

@Service
public class PatrimonioService {

    @Autowired
    private PatrimonioRepository patrimonioRepository;

    @Autowired
    private CampusRepositoty campusRepository;

    public void importarCsv() {
        try (
                InputStream is = getClass().getClassLoader().getResourceAsStream("patrimonio-2019.csv");
                InputStreamReader isr = new InputStreamReader(is);
                CSVReader reader = new CSVReader(isr)
        ) {
            String[] linha;
            boolean primeiraLinha = true;

            while ((linha = reader.readNext()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                try {
                    PatrimonioDto dto = TratamentoDeDados.tratarDados(linha);
                    if (dto != null && "CAMPUS CAMPINA GRANDE".equalsIgnoreCase(dto.getCampus())) {
                        Patrimonio patrimonio = converterDtoParaEntidade(dto);
                        patrimonioRepository.save(patrimonio);
                    }

                } catch (Exception e) {
                    System.out.println("Erro ao tratar os dados: " + Arrays.toString(linha));
                    e.printStackTrace();
                }
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException("Erro ao ler o arquivo CSV com OpenCSV", e);
        }
    }

    public Patrimonio converterDtoParaEntidade(PatrimonioDto dto) {
        Campus campus = campusRepository.findByNome(dto.getCampus())
                .orElseGet(() -> {
                    Campus novoCampus = new Campus();
                    novoCampus.setNome(dto.getCampus());
                    return campusRepository.save(novoCampus);
                });

        Patrimonio patrimonio = new Patrimonio();
        patrimonio.setNumero(dto.getNumero());
        patrimonio.setDescricao(dto.getDescricao());
        patrimonio.setSituacao(dto.getSituacao());
        patrimonio.setEstadoConservacao(dto.getEstadoConservacao());
        patrimonio.setValorInicial(BigDecimal.valueOf(dto.getValorInicial()));
        patrimonio.setValorLiquidoContabil(BigDecimal.valueOf(dto.getValorLiquido()));
        patrimonio.setCampus(campus);

        return patrimonio;
    }
}