package com.desafio.nerds.patrimonio.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.nerds.patrimonio.model.Equipamento;

import java.util.List;
import java.util.Optional;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
    boolean existsByNumeroSerie(String numeroSerie);
    
    Optional<Equipamento> findByNumeroSerie(String numeroSerie);
    List<Equipamento> findByTipo(String tipo);
}