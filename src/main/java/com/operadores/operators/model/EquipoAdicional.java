package com.operadores.operators.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cache;

import java.io.Serializable;

@SuppressWarnings("serial")
@Entity
@Table(name = "equipo_adicional")
@Data
@Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE)
public class EquipoAdicional implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "viaje_id", nullable = false)
    private Viaje viaje;


    @Column(name = "descripcion")
    private String descripcion;
}
