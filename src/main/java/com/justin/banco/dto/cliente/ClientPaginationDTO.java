package com.justin.banco.dto.cliente;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ClientPaginationDTO(
                @NotNull(message = "Offset es requerido para la paginación") @Min(value = 0, message = "Offset debe ser mayor o igual a 0") Integer offset,
                @NotNull(message = "limit es requerido para la paginación") @Min(value = 1, message = "limit debe ser mayor o igual a 1") Integer limit,
                String nombre,
                Integer distrito,
                Integer cedula) {

}
// filtros deben permitir nulos por si no se quiere filtrar
// Si es numerico tiene que ser Integer para permitir valores nulos
// si se envia un null es postman y la variable es int el valor por defecto es 0