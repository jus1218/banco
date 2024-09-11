package com.justin.banco.models;

public class Telefono {

    private final int codigoTelefono;
    private final String numero;
    private final String descripcion;

    public Telefono(int codigoTelefono, String numero, String descripcion) {
        this.codigoTelefono = codigoTelefono;
        this.numero = numero;
        this.descripcion = descripcion;
    }

    public int getCodigoTelefono() {
        return codigoTelefono;
    }

    public String getNumero() {
        return numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
