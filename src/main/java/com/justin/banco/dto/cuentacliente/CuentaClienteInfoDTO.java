package com.justin.banco.dto.cuentacliente;

import java.math.BigDecimal;
import java.math.RoundingMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CuentaClienteInfoDTO {

    @Id
    @Column(name = "codigo_cuenta_cliente")
    private Integer codigoCuentaCliente;

    @Column(name = "codigo_banco")
    private String codigoBanco;

    @Column(name = "codigo_moneda")
    private String codigoMoneda;

    @Column(name = "saldo")
    private BigDecimal saldo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "codigo_tipo_cuenta_cliente")
    private String codigoTipoCuentaCliente;

    @Column(name = "codigo_cuenta_contable")
    private Long codigoCuentaContable;

    @Column(name = "codigo_cliente")
    private Integer codigoCliente;

    public CuentaClienteInfoDTO() {
    }

    public Integer getCodigoCuentaCliente() {
        return codigoCuentaCliente;
    }

    public void setCodigoCuentaCliente(Integer codigoCuentaCliente) {
        this.codigoCuentaCliente = codigoCuentaCliente;
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

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) { 
        this.saldo =  saldo.setScale(2, RoundingMode.HALF_UP);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoTipoCuentaCliente() {
        return codigoTipoCuentaCliente;
    }

    public void setCodigoTipoCuentaCliente(String codigoTipoCuentaCliente) {
        this.codigoTipoCuentaCliente = codigoTipoCuentaCliente;
    }

    public Long getCodigoCuentaContable() {
        return codigoCuentaContable;
    }

    public void setCodigoCuentaContable(Long codigoCuentaContable) {
        this.codigoCuentaContable = codigoCuentaContable;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

}
