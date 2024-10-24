package com.justin.banco.dto.cuentacontable;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CuentaContablePaginationDTO(
                @NotNull(message = "Offset es requerido para la paginación") @Min(value = 0, message = "Offset debe ser mayor o igual a 0") Integer offset,
                @NotNull(message = "limit es requerido para la paginación") @Min(value = 1, message = "limit debe ser mayor o igual a 1") Integer limit,
                @Size(min = 1, max = 3, message = "Codigo moneda no puede ir vacio") String codigoBanco) {

}