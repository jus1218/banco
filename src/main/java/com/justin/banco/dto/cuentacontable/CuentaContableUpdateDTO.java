package com.justin.banco.dto.cuentacontable;
 

import jakarta.validation.constraints.Min; 
import jakarta.validation.constraints.Size;

public record CuentaContableUpdateDTO(

        Long codigoCuentaContable,

        @Size(min = 1, message = "El campo no puede estar vacío") String codigoBanco,

        @Size(min = 1, message = "El campo no puede estar vacío") String codigoMoneda,

        @Size(min = 1, message = "El campo no puede estar vacío") String descripcion,

        @Min(value = 1, message = "El campo no puede estar vacío") Integer codigoTipoCuentaContable

) {

    public CuentaContableUpdateDTO copyWith(Long codigoCuentaContable) {
        return new CuentaContableUpdateDTO(codigoCuentaContable, codigoBanco,
                codigoMoneda,
                descripcion,
                codigoTipoCuentaContable);
    }

}
