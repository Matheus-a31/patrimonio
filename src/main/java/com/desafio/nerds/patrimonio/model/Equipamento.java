package com.desafio.nerds.patrimonio.model;

import jakarta.persistence.*;
import lombok.Data;

@Data 
@Entity
@Table(name = "tb_equipamentos")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false, unique = true)
    private String numeroSerie;
}