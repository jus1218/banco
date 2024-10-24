package com.justin.banco.dto.selector;

public class ClienteSelector {
    private long codigoCliente;
    private String nombreCompleto;

    public long getCodigoCliente() { return codigoCliente; }
    public void setCodigoCliente(long value) { this.codigoCliente = value; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String value) { this.nombreCompleto = value; }
}
 