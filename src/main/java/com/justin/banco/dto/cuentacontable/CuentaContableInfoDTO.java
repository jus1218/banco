package com.justin.banco.dto.cuentacontable;

import java.math.BigDecimal;
import java.math.RoundingMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CuentaContableInfoDTO {
    @Id
    @Column(name = "codigo_cuenta_contable")
    private Long codigoCuentaContable;
    @Column(name = "codigo_banco")
    private String codigoBanco;
    @Column(name = "codigo_moneda")
    private String codigoMoneda;
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "saldo")
    private BigDecimal saldo;

    @Column(name = "codigo_tipo_cuenta_contable")
    private Long codigoTipoCuentaContable;

    public CuentaContableInfoDTO() {
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

    public Long getCodigoTipoCuentaContable() {
        return codigoTipoCuentaContable;
    }

    public void setCodigoTipoCuentaContable(Long codigoTipoCuentaContable) {
        this.codigoTipoCuentaContable = codigoTipoCuentaContable;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {

        BigDecimal saldoFormateado = saldo.setScale(2, RoundingMode.HALF_UP);

        this.saldo = saldoFormateado;
    }

}
