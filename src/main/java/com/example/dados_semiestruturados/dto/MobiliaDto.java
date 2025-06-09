package com.example.dados_semiestruturados.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MobiliaDto {

    private Long id;
    private String numero;
    private String descricao;
    private String situacao;
    private String estadoConservacao;
    private String campus;
    private double valorInicial;
    private double valorLiquido;
}