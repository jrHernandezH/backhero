package com.operadores.operators.repository;

import com.operadores.operators.enums.EstadoEnum;
import com.operadores.operators.model.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Long> {
    Optional<Viaje> findByEstado(EstadoEnum estado);
}
