package com.justin.banco.dto.cuentacliente;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CuentaClientePaginacionDTO(
                @NotNull(message = "Offset es requerido para la paginación") @Min(value = 0, message = "Offset debe ser mayor o igual a 0") Integer offset,
                @NotNull(message = "limit es requerido para la paginación") @Min(value = 1, message = "limit debe ser mayor o igual a 1") Integer limit,
                @Min(value = 1, message = "limit debe ser mayor o igual a 1") Integer codigoCliente) {

}
