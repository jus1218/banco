package com.justin.banco.dto.selector;


public class BancoSelector {
    private String codigoBanco;
    private String codigoMoneda;
    private String nombre;

    public String getCodigoBanco() { return codigoBanco; }
    public void setCodigoBanco(String value) { this.codigoBanco = value; }
 
    public String getNombre() { return nombre; }
    public void setNombre(String value) { this.nombre = value; }
    public String getCodigoMoneda() { return codigoMoneda; }
    public void setCodigoMoneda(String codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
    }
}
