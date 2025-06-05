package com.example.dados_semiestruturados.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data

@Entity
public class Patrimonio {

    @Id
    @Column(name = "numero")
    private String numero;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "situacao")
    private String situacao;

    @Column(name = "estado_conservacao")
    private String estadoConservacao;

    @Column(name = "valor_inicial")
    private BigDecimal valorInicial;

    @Column(name = "valor_liquido_contabil")
    private BigDecimal valorLiquidoContabil;

    @ManyToOne
    @JoinColumn(name = "campus_id")
    private Campus campus;
}