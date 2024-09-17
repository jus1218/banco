package com.justin.banco.dto.moneda;

import com.justin.banco.models.Moneda;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MonedaCreateDTO(
                @NotNull(message = "Es requerido") @Size(min = 1, message = "El campo no puede estar vacío") String codigoMoneda,
                @NotNull(message = "Es requerido") @Size(min = 1, message = "El campo no puede estar vacío") String nombre) {

        
}
