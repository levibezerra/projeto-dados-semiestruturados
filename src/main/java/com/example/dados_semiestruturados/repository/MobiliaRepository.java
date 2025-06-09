package com.example.dados_semiestruturados.repository;

import com.example.dados_semiestruturados.entity.Mobilia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobiliaRepository extends JpaRepository<Mobilia, Long> {
    boolean existsByNumero(String numero);
}