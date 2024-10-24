package com.justin.banco.dto.tipocuentacliente;

public class TipoCuentaClienteInfoDTO {

    private String codigoTipoCuentaCliente;

    private String nombre;

    public TipoCuentaClienteInfoDTO() {
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
