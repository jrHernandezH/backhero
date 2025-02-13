package com.operadores.operators.dto.create;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ViajeCreate {

    private String numeroUnidad;

    private String numeroFactura;

    private String numeroViaje;

    private String numeroValeDiesel;

    private Long odometro;

    private String imgOdometro;

    private String tanque;

    private String imgTanqueo;

    private String numeroVale;

    private Boolean verificacionLlantas;

    private String equipoAdicional;

    private String serviciosForaneos;

    private LocalDateTime fechaInicio;

    private LocalDateTime fechaFin;
}
