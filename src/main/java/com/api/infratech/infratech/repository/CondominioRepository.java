package com.api.infratech.infratech.repository;

import com.api.infratech.infratech.model.Condominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CondominioRepository extends JpaRepository<Condominio, Long> {
    Condominio findByNome(String nome);
}
