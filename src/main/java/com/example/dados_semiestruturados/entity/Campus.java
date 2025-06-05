package com.example.dados_semiestruturados.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity
public class Campus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;
}