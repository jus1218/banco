package com.justin.banco.dto.cuentacontable;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CuentaContableCreateDTO(

        @NotNull(message = "Es requerido") @Min(value = 1, message = "El campo no puede estar vacío") Long codigoCuentaContable,

        @NotNull(message = "Es requerido") @Size(min = 1, message = "El campo no puede estar vacío") String codigoBanco,

        @NotNull(message = "Es requerido") @Size(min = 1, message = "El campo no puede estar vacío") String codigoMoneda,

        @NotNull(message = "Es requerido") @Size(min = 1, message = "El campo no puede estar vacío") String descripcion,

        @NotNull(message = "Es requerido") @Min(value = 1, message = "El campo no puede estar vacío") Integer codigoTipoCuentaContable) {

}
