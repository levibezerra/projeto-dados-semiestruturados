package com.example.dados_semiestruturados.util;

import com.example.dados_semiestruturados.dto.PatrimonioDto;

import java.util.Arrays;

public class TratamentoDeDados {

    public static PatrimonioDto tratarDados(String[] campos) {
        try {
            String numero = campos[0].trim();
            String descricao = campos[1].trim();
            String situacao = campos[2].trim().toUpperCase();

            String estadoConservacao = campos[3].trim().isEmpty() ? "NÃO INFORMADO": campos[3].trim().toUpperCase();
            String campus = campos[4].trim().toUpperCase().replaceAll(" +", " ");

            double valorInicial = Double.parseDouble(campos[5].trim().replace(",", "."));
            double valorLiquido = Double.parseDouble(campos[6].trim().replace(",", "."));

            return new PatrimonioDto(numero, descricao, situacao, estadoConservacao, campus, valorInicial, valorLiquido);
        } catch (Exception e) {
            System.out.println("Erro ao tratar os dados: " + Arrays.toString(campos));
            return null;
        }
    }
}