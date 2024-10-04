package com.justin.banco.dto.telefono;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TelefonoCreateDTO(
        @NotNull(message = "Es requerido") @Size(min = 1, max = 15, message = "El campo no puede estar vacío") String numero,
        @Size(min = 1, max = 3, message = "El campo no puede estar vacío") String codigoBanco,
        @Min(value = 1, message = "El campo no puede estar vacío") Integer codigoCliente

) {
}
