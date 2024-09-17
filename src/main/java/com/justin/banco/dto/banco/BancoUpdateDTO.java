package com.justin.banco.dto.banco;
 
import jakarta.validation.constraints.Size;

public record BancoUpdateDTO(
               @Size(min = 1, message = "El campo no puede estar vacío") String codigoBanco,
               @Size(min = 1, message = "El campo no puede estar vacío") String nombre,
               @Size(min = 1, message = "El campo no puede estar vacío") String direccionExacta,
               @Size(min = 1, message = "El campo no puede estar vacío") String codigoMoneda,
                Integer codigoDistrito) {

        public BancoUpdateDTO copyWith(String pCodigoBanco) {
                return new BancoUpdateDTO(pCodigoBanco,
                                nombre,
                                direccionExacta,
                                codigoMoneda,
                                codigoDistrito);
        }
}
