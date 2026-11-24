package com.api.infratech.infratech.repository;

import com.api.infratech.infratech.model.Defeito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefeitoRepository extends JpaRepository<Defeito, Long> {
}
