package com.api.infratech.infratech.repository;

import com.api.infratech.infratech.model.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Chamadorepository extends JpaRepository<Chamado, Long> {
}
