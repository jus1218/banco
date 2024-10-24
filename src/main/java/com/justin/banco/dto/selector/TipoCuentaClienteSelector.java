package com.justin.banco.dto.selector;

public class TipoCuentaClienteSelector {
    private String codigoTipoCuentaCliente;
    private String nombre;


    public TipoCuentaClienteSelector() {
    }

    
    public String getCodigoTipoCuentaCliente() {
        return codigoTipoCuentaCliente;
    }
    public void setCodigoTipoCuentaCliente(String codigoTipoCuentaCliente) {
        this.codigoTipoCuentaCliente = codigoTipoCuentaCliente;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
  

}
