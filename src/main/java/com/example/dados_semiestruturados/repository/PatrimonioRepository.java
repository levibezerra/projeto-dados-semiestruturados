package com.example.dados_semiestruturados.repository;

import com.example.dados_semiestruturados.entity.Patrimonio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatrimonioRepository extends JpaRepository<Patrimonio, Long> {

    List<Patrimonio> findByDescricaoContainingIgnoreCase(String termo);
}