package com.justin.banco.dto.cliente;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ClienteCreateDTO(
        @NotNull(message = "Es requerido") @Size(min = 1, message = "El campo no puede estar vacío") String nombre,
        @NotNull(message = "Es requerido") @Size(min = 1, message = "El campo no puede estar vacío") String primerApellido,
        @NotNull(message = "Es requerido") @Size(min = 1, message = "El campo no puede estar vacío") String segundoApellido,
        @NotNull(message = "Es requerido") @Min(value = 1, message = "El campo no puede estar vacío") Integer cedula,
        @NotNull(message = "Es requerido") @Size(min = 1, message = "El campo no puede estar vacío") String direccionExacta,
        @NotNull(message = "Es requerido") @Min(value = 1, message = "El campo no puede estar vacío") Integer distrito) {

}
