package com.operadores.operators.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MarcaEnum {
    KENWORTH("Kenworth"),
    INTERNATIONAL("International"),
    FREIGHTLINER("Freightliner"),
    VOLVO("Volvo"),
    SCANIA("Scania"),
    MERCEDES_BENZ("Mercedes Benz");

    private String modelo;
}
