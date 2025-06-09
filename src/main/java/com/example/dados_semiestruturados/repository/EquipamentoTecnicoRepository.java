package com.example.dados_semiestruturados.repository;

import com.example.dados_semiestruturados.entity.EquipamentoTecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentoTecnicoRepository extends JpaRepository<EquipamentoTecnico, Long> {
    boolean existsByNumero(String numero);
}