package com.example.dados_semiestruturados.dto;

public class PatrimonioDto {

    private String numero;
    private String descricao;
    private String situacao;
    private String estadoConservacao;
    private String campus;
    private double valorInicial;
    private double valorLiquido;

    public PatrimonioDto(String numero, String descricao, String situacao,
                         String estadoConservacao, String campus, double valorInicial,
                         double valorLiquido) {
        this.numero = numero;
        this.descricao = descricao;
        this.situacao = situacao;
        this.estadoConservacao = estadoConservacao;
        this.valorInicial = valorInicial;
        this.campus = campus;
        this.valorLiquido = valorLiquido;
    }

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

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public double getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(double valorLiquido) {
        this.valorLiquido = valorLiquido;
    }
}