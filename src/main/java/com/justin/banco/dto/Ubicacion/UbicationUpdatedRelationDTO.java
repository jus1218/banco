package com.justin.banco.dto.Ubicacion;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UbicationUpdatedRelationDTO(
        @Min(value = 0) Integer codigo,
        @Size(min = 1, max = 20, message = "tamaño debe ser mayor a 1 y menor 20") String nombre,
        @NotNull(message = "Es requerido") @Min(value = 0, message = "Debe ser 0,1,2") Integer type,
        @NotNull(message = "Es requerido") @Min(value = 0, message = "Debe ser mayor a 0") Integer idRelacion) {
    public UbicationUpdatedRelationDTO copyWith(Integer codigo) {
        return new UbicationUpdatedRelationDTO(codigo, nombre, type, idRelacion);
    }
}
