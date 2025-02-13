package com.operadores.operators.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ViajeRequest {

    private Long id;

    private String numeroUnidad;

    private String numeroFactura;

    private String numeroVale;

    private String numeroViaje;

    private String numeroValeDiesel;

    private Long odometro;

    private String tanque;

    private String imagenTanque;

    private String imagenOdometro;

    private String equipoAdicional;

    private String serviciosForaneos;

    private boolean verificacionLlantas;

    private LocalDateTime fechaInicio;

    private LocalDateTime fechaFin;

    private String estado;
}
