package com.example.dados_semiestruturados.repository;

import com.example.dados_semiestruturados.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    boolean existsByNumero(String numero);
}