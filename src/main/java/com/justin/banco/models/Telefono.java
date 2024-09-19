package com.justin.banco.models;

public class Telefono {

    private final int codigoTelefono;
    private final String numero; 

    public Telefono(int codigoTelefono, String numero ) {
        this.codigoTelefono = codigoTelefono;
        this.numero = numero; 
    }

    public int getCodigoTelefono() {
        return codigoTelefono;
    }

    public String getNumero() {
        return numero;
    }
 

}
