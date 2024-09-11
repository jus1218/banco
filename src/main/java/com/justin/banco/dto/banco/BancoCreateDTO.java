package com.justin.banco.dto.banco;

import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BancoCreateDTO(
        @NotNull(message = "Codigo banco es requerido") @NotBlank(message = "Rellene el campo codigo banco") String codigoBanco,
        @NotNull(message = "Nombre banco es requerido") @NotBlank(message = "Rellene el campo nombre del banco") String nombre,
        @NotNull(message = "codigo moneda es requerido") @NotBlank(message = "Rellene el campo moneda") String codigoMoneda,
        @NotNull(message = "codigo distrito es requerido") Integer codigoDistrito,
        @NotNull(message = "direccion exacta es requerido") String direccionExacta) {

}
