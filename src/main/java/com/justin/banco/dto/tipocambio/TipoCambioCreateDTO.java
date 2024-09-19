package com.justin.banco.dto.tipocambio;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record TipoCambioCreateDTO(
        @NotNull(message = "Es requerido") @Size(min = 1, message = "El campo no puede estar vacío") String codigoMoneda,
        @NotNull(message = "Es requerido")  @Pattern(regexp = "^[0-9]{8}$", message = "El formato de la fecha debe ser YYYYMMDD") String fecha,
        @NotNull(message = "Es requerido") @Min(value = 0, message = "El campo no puede estar vacío") Double tipoCambioCompra,
        @NotNull(message = "Es requerido") @Min(value = 0, message = "El campo no puede estar vacío") Double tipoCambioVenta,
        @NotNull(message = "Es requerido") @Size(min = 1, message = "El campo no puede estar vacío") String codigoBanco

) {

}
