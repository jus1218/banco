package com.justin.banco.dto.tipocambio;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record TipoCambioUpdateDTO(

        @NotNull(message = "Es requerido") @Size(min = 1,max = 3, message = "tamaño debe ser mayor a 1 y menor 3") String codigoMoneda,
        @NotNull(message = "Es requerido") @Pattern(regexp = "^[0-9]{8}$", message = "El formato de la fecha debe ser YYYYMMDD") String fecha,
        @Min(value = 0, message = "El campo no puede estar vacío") Double tipoCambioCompra,
        @Min(value = 0, message = "El campo no puede estar vacío") Double tipoCambioVenta,
        @NotNull(message = "Es requerido") @Size(min = 1,max = 3, message = "tamaño debe ser mayor a 1 y menor 3") String codigoBanco) {
    public TipoCambioUpdateDTO copyWith(String pCodigoBanco) {
        return new TipoCambioUpdateDTO(codigoMoneda,
                fecha,
                tipoCambioCompra,
                tipoCambioVenta,
                codigoBanco);
    }
}
