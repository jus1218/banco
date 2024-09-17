package com.justin.banco.dto.banco;

// import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record BancoCreateDTO(
                @NotNull(message = "Es requerido") @Size(min = 1, message = "El campo no puede estar vacío") String codigoBanco,
                @NotNull(message = "Es requerido") @Size(min = 1, message = "El campo no puede estar vacío") String nombre,
                @NotNull(message = "Es requerido") @Size(min = 1, message = "El campo no puede estar vacío") String direccionExacta,
                @NotNull(message = "Es requerido") @Size(min = 1, message = "El campo no puede estar vacío") String codigoMoneda,
                @NotNull(message = "Es requerido") Integer codigoDistrito

) {

}
