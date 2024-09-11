package com.justin.banco.dto.banco;

import java.util.List;

import com.justin.banco.models.Telefono;

public record BancoDetailsDTO(String codigoBanco,
        String nombre,
        String codigoMoneda,
        int codigoDistrito,
        String direccionExacta,
        List<Telefono> telefonos) {

}
