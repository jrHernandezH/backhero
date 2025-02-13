package com.operadores.operators.repository;

import com.operadores.operators.model.Remision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemisionRepository extends JpaRepository<Remision,Long> {
}
