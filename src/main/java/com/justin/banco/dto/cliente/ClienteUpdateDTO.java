package com.justin.banco.dto.cliente;
 
import jakarta.validation.constraints.Size;


public record ClienteUpdateDTO(
        Integer codigoCliente,
        @Size(min = 1, message = "El campo no puede estar vacío") String nombre,
        @Size(min = 1, message = "El campo no puede estar vacío") String primerApellido,
        @Size(min = 1, message = "El campo no puede estar vacío") String segundoApellido,
        Integer cedula,
        @Size(min = 1, message = "El campo no puede estar vacío") String direccionExacta,
        Integer distrito) {

    public ClienteUpdateDTO copyWith(Integer pCodigoCliente) {
        return new ClienteUpdateDTO(pCodigoCliente,
                nombre,
                primerApellido,
                segundoApellido,
                cedula,
                direccionExacta,
                distrito);
    }

}
