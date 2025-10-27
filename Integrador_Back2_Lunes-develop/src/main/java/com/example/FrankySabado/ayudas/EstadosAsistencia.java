package com.example.FrankySabado.ayudas;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EstadosAsistencia {
    PRESENTE("presente"),
    AUSENTE("ausente"),
    TARDANZA("tardanza"),
    JUSTIFICADO("justificado");

    private final String value;

    EstadosAsistencia(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static EstadosAsistencia fromValue(String value) {
        if (value == null) return null;
        for (EstadosAsistencia e : EstadosAsistencia.values()) {
            if (e.value.equalsIgnoreCase(value) || e.name().equalsIgnoreCase(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Estado de asistencia desconocido: " + value);
    }
}