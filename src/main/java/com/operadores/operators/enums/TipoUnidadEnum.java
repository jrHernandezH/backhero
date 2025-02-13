package com.operadores.operators.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoUnidadEnum {
    TRACTOCAMION("Tractocamion"),
    CAMION("Camion"),
    CAMIONETA("Camioneta"),
    TORTON("Torton");

    private String tipoUnidad;
}
