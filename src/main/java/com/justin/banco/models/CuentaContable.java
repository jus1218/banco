package com.justin.banco.models;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CuentaContable {

    private Long codigoCuentaContable;
    private String codigoBanco;
    private String codigoMoneda;
    private String descripcion;
    private BigDecimal saldo;
    private String tipoCuentaContable;

    public CuentaContable() {
    }

    public Long getCodigoCuentaContable() {
        return codigoCuentaContable;
    }

    public void setCodigoCuentaContable(Long codigoCuentaContable) {
        this.codigoCuentaContable = codigoCuentaContable;
    }

    public String getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(String banco) {
        this.codigoBanco = banco;
    }

    public String getCodigoMoneda() {
        return codigoMoneda;
    }

    public void setCodigoMoneda(String moneda) {
        this.codigoMoneda = moneda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        BigDecimal saldoFormateado = saldo.setScale(2, RoundingMode.HALF_UP);
        this.saldo = saldoFormateado;
    }

    public String getTipoCuentaContable() {
        return tipoCuentaContable;
    }

    public void setTipoCuentaContable(String tipoCuentaContable) {
        this.tipoCuentaContable = tipoCuentaContable;
    }

}
