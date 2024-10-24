package com.justin.banco.dto.selector;

public class TipoCuentaContableSelector {

    private Integer codigoTipoCuentaContable;
    private String nombre;

    public TipoCuentaContableSelector() {
    }

    public Integer getCodigoTipoCuentaContable() {
        return codigoTipoCuentaContable;
    }

    public void setCodigoTipoCuentaContable(Integer codigoTipoCuentaContable) {
        this.codigoTipoCuentaContable = codigoTipoCuentaContable;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
