package com.example.dados_semiestruturados.repository;

import com.example.dados_semiestruturados.entity.Campus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CampusRepositoty extends JpaRepository<Campus, Long> {

    Optional<Campus> findByNome(String nome);
}