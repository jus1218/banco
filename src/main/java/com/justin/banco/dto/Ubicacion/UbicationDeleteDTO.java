package com.justin.banco.dto.Ubicacion;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record UbicationDeleteDTO(
        @Min(value = 0) Integer codigo,
        @NotNull(message = "Es requerido") @Min(value = 0, message = "Debe ser 0,1,2") Integer type) {

}
