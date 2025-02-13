package com.operadores.operators.repository;

import com.operadores.operators.model.EquipoAdicional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoAdcionalRepository extends JpaRepository<EquipoAdicional,Long> {
}
