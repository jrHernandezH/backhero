package com.operadores.operators.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cache;

import java.io.Serializable;

@SuppressWarnings("serial")
@Entity
@Table(name = "gastos")
@Data
@Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE)
public class Gasto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "concepto")
    private String concepto;

    @Column(name = "monto")
    private Double monto;

    @Column(name = "img_gasto")
    private String imgGasto;
}
