package com.justin.banco.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import com.justin.banco.dto.banco.BancoInfoDTO;
import com.justin.banco.dto.cliente.ClienteInfoDTO;
import com.justin.banco.dto.cuentacontable.CuentaContableInfoDTO;
import com.justin.banco.dto.moneda.MonedaInfoDTO;
import com.justin.banco.dto.tipocuentacliente.TipoCuentaClienteInfoDTO;

public class CuentaCliente {
    private Integer codigoCuentaCliente;
    private BancoInfoDTO banco;
    private MonedaInfoDTO moneda;
    private BigDecimal saldo;
    private String descripcion;
    private TipoCuentaClienteInfoDTO tipoCuentaCliente;
    private CuentaContableInfoDTO cuentaContable;
    private ClienteInfoDTO cliente;

    public CuentaCliente() {
    }

    public Integer getCodigoCuentaCliente() {
        return codigoCuentaCliente;
    }

    public void setCodigoCuentaCliente(Integer codigoCuentaCliente) {
        this.codigoCuentaCliente = codigoCuentaCliente;
    }

    public BancoInfoDTO getBanco() {
        return banco;
    }

    public void setBanco(BancoInfoDTO banco) {
        this.banco = banco;
    }

    public MonedaInfoDTO getMoneda() {
        return moneda;
    }

    public void setMoneda(MonedaInfoDTO moneda) {
        this.moneda = moneda;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        BigDecimal saldoFormateado = saldo.setScale(2, RoundingMode.HALF_UP);
        this.saldo = saldoFormateado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoCuentaClienteInfoDTO getTipoCuentaCliente() {
        return tipoCuentaCliente;
    }

    public void setTipoCuentaCliente(TipoCuentaClienteInfoDTO tipoCuentaCliente) {
        this.tipoCuentaCliente = tipoCuentaCliente;
    }

    public CuentaContableInfoDTO getCuentaContable() {
        return cuentaContable;
    }

    public void setCuentaContable(CuentaContableInfoDTO cuentaContable) {
        this.cuentaContable = cuentaContable;
    }

    public ClienteInfoDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteInfoDTO cliente) {
        this.cliente = cliente;
    }

}
