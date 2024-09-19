package com.justin.banco.dto.tipocambio;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record TipoCambioDeleteAndUpdateDTO(
        @NotNull(message = "Es requerido") @Size(min = 1, message = "El campo no puede estar vacío") String codigoMoneda,
        @NotNull(message = "Es requerido") @Pattern(regexp = "^[0-9]{8}$", message = "El formato de la fecha debe ser YYYYMMDD") String fecha,
        @NotNull(message = "Es requerido") @Size(min = 1, message = "El campo no puede estar vacío") String codigoBanco) {
}
