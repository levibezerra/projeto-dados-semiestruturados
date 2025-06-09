package com.example.dados_semiestruturados.repository;

import com.example.dados_semiestruturados.entity.EquipamentoDeInformatica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentoDeInformaticaRepository extends JpaRepository<EquipamentoDeInformatica, Long> {
    boolean existsByNumero(String numero);
}