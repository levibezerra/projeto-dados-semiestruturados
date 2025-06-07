package com.example.dados_semiestruturados.dto;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor

public class PatrimonioDto {

    private String numero;
    private String descricao;
    private String situacao;
    private String estadoConservacao;
    private String campus;
    private double valorInicial;
    private double valorLiquido;
}