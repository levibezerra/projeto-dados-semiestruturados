package com.example.dados_semiestruturados.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    private Campus campus;
}