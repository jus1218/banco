package com.justin.banco.dto.selector;

public class CuentaContableSelector {
    private long codigoCuentaContable;
    private String codigoBanco;
    private String codigoMoneda;
    private String descripcion;

    public CuentaContableSelector() {
    }

    public long getCodigoCuentaContable() {
        return codigoCuentaContable;
    }

    public void setCodigoCuentaContable(long codigoCuentaContable) {
        this.codigoCuentaContable = codigoCuentaContable;
    }

    public String getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(String codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public String getCodigoMoneda() {
        return codigoMoneda;
    }

    public void setCodigoMoneda(String codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

}
