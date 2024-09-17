package com.justin.banco.dto.moneda;

 
import jakarta.validation.constraints.Size;

public record MonedaUpdateDTO(
        @Size(min = 1, message = "El campo no puede estar vacío") String codigoMoneda,
        @Size(min = 1, message = "El campo no puede estar vacío") String nombre) {
    public MonedaUpdateDTO copyWith(String codigoMoneda) {
        return new MonedaUpdateDTO(codigoMoneda, nombre);
    }

}
