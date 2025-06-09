package com.example.dados_semiestruturados.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor

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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getEstadoConservacao() {
        return estadoConservacao;
    }

    public void setEstadoConservacao(String estadoConservacao) {
        this.estadoConservacao = estadoConservacao;
    }

    public BigDecimal getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(BigDecimal valorInicial) {
        this.valorInicial = valorInicial;
    }

    public BigDecimal getValorLiquidoContabil() {
        return valorLiquidoContabil;
    }

    public void setValorLiquidoContabil(BigDecimal valorLiquidoContabil) {
        this.valorLiquidoContabil = valorLiquidoContabil;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }
}