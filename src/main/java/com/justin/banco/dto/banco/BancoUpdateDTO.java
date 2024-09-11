package com.justin.banco.dto.banco;

public record BancoUpdateDTO(
                String codigoBanco,
                String nombre,
                String codigoMoneda,
                Integer codigoDistrito,
                String direccionExacta) {

        public BancoUpdateDTO copyWith(String pCodigoBanco) {
                return new BancoUpdateDTO(pCodigoBanco,
                                nombre,
                                codigoMoneda,
                                codigoDistrito,
                                direccionExacta);
        }
}
