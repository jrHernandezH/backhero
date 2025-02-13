package com.operadores.operators.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstadoEnum {
    ACTIVO("Activo"),
    INACTIVO("Inactivo");

    private String estado;
}
