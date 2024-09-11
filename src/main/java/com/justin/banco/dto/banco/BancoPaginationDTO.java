package com.justin.banco.dto.banco;

import jakarta.validation.constraints.NotNull;

public record BancoPaginationDTO(
                @NotNull(message = "Offset es requerido para la paginación") Integer offset,
                @NotNull(message = "limit es requerido para la paginación") Integer limit,
                String nombre,
                String district) {

}
