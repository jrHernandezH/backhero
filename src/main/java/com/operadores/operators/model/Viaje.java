package com.operadores.operators.model;

import com.operadores.operators.enums.EstadoEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
@Entity
@Table(name = "viajes")
@Data
@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE)
public class Viaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_unidad", nullable = false)
    private String numeroUnidad;

    @Column(name = "numero_factura")
    private String numeroFactura;

    @Column(name = "numero_vale")
    private String numeroVale;

    @Column(name = "numero_viaje")
    private String numeroViaje;

    @Column(name = "numero_vale_diesel")
    private String numeroValeDiesel;

    @Column(name = "odometro")
    private Long odometro;

    @Column(name = "tanque")
    private String tanque;

    @Column(name = "imagen_tanque")
    private String imagenTanque;

    @Column(name = "imagen_odometro")
    private String imagenOdometro;

    @Column(name = "equipo_adicional")
    private String equipoAdicional;

    @Column(name = "servicios_foraneos")
    private String serviciosForaneos;

    @Column(name = "verificacion_llantas")
    private boolean verificacionLlantas;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDateTime fechaFin;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private EstadoEnum estado;
}
