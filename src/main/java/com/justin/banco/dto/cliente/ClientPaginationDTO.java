package com.justin.banco.dto.cliente;

import jakarta.validation.constraints.NotNull;

public record ClientPaginationDTO(
        @NotNull(message = "Offset es requerido para la paginación") Integer offset,
        @NotNull(message = "limit es requerido para la paginación") Integer limit,
        String nombre,
        Integer distrito,
        Integer cedula) {

}
//filtros deben permitir nulos por si no se quiere filtrar
//Si es numerico tiene que ser Integer para permitir valores nulos
//si se envia un null es postman y la variable es int el valor por defecto es 0