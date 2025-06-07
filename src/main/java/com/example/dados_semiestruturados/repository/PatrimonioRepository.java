package com.example.dados_semiestruturados.repository;

import com.example.dados_semiestruturados.entity.Patrimonio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatrimonioRepository extends JpaRepository<Patrimonio, Long> {
}