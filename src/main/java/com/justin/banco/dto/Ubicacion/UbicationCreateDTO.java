package com.justin.banco.dto.Ubicacion;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UbicationCreateDTO(
        @NotNull(message = "Es requerido") @Min(value = 1, message = "El campo no puede ser numeros negativos") Integer codigo,
        @NotNull(message = "Es requerido") @Size(min = 1, message = "El campo no puede estar vacío") String nombre,
        @NotNull(message = "Es requerido") @Min(value = 0, message = "El campo no puede estar vacío") Integer type,
        @Min(value = 0, message = "El campo no puede estar vacío") Integer idRelacion

) {

}
