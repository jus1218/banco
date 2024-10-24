package com.justin.banco.dto.cuentacliente;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public record CuentaClienteUpdateDTO(

        @Min(value = 0, message = "El campo no puede estar vacío") Long codigoCuentaCliente,
        @Size(min = 1, message = "El campo no puede estar vacío") String codigoBanco,
        @Size(min = 1, message = "El campo no puede estar vacío") String codigoMoneda,

        @Size(min = 1, message = "El campo no puede estar vacío") String descripcion,

        @Size(min = 1, message = "El campo no puede estar vacío") String codigoTipoCuentaCliente,

        @Min(value = 0, message = "El campo no puede estar vacío") Long codigoCuentaContable,

        @Min(value = 0, message = "El campo no puede estar vacío") Integer codigoCliente) {
    public CuentaClienteUpdateDTO copyWith(Long pCodigoCuentaCliente) {
        return new CuentaClienteUpdateDTO(pCodigoCuentaCliente,
                codigoBanco,
                codigoMoneda,
                descripcion,
                codigoTipoCuentaCliente,
                codigoCuentaContable,
                codigoCliente);
    }
}
