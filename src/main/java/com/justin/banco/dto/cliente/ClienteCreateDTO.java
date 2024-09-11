package com.justin.banco.dto.cliente;

import jakarta.validation.constraints.NotNull;

public record ClienteCreateDTO(
        @NotNull(message = "Nombre cliente es requerido") String nombre,
        @NotNull(message = "Primer apellido es requerido") String primerApellido,
        @NotNull(message = "Segundo apellido es requerido") String segundoApellido,
        @NotNull int cedula,
        @NotNull int distrito,
        @NotNull(message = "Direccion exacta es requerida") String direccionExacta) {
}
