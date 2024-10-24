package com.justin.banco.models;

import com.justin.banco.dto.selector.BancoSelector;
import com.justin.banco.dto.selector.ClienteSelector;
import com.justin.banco.dto.selector.CuentaContableSelector;
import com.justin.banco.dto.selector.MonedaSelector;
import com.justin.banco.dto.selector.TipoCuentaClienteSelector;
import com.justin.banco.dto.selector.TipoCuentaContableSelector;

public class Selector {
    private BancoSelector[] bancos;
    private MonedaSelector[] monedas;
    private TipoCuentaClienteSelector[] tipoCuentaClientes;
    private TipoCuentaContableSelector[] tipoCuentaContables;

    private CuentaContableSelector[] cuentaContables;
    private ClienteSelector[] clientes;
    private Provincia[] provincias;

    public Selector() {
    }

    public BancoSelector[] getBancos() {
        return bancos;
    }

    public void setBancos(BancoSelector[] bancos) {
        this.bancos = bancos;
    }

    public MonedaSelector[] getMonedas() {
        return monedas;
    }

    public void setMonedas(MonedaSelector[] monedas) {
        this.monedas = monedas;
    }

    public TipoCuentaClienteSelector[] getTipoCuentaClientes() {
        return tipoCuentaClientes;
    }

    public void setTipoCuentaClientes(TipoCuentaClienteSelector[] tipoCuentaClientes) {
        this.tipoCuentaClientes = tipoCuentaClientes;
    }

    public CuentaContableSelector[] getCuentaContables() {
        return cuentaContables;
    }

    public void setCuentaContables(CuentaContableSelector[] cuentaContables) {
        this.cuentaContables = cuentaContables;
    }

    public ClienteSelector[] getClientes() {
        return clientes;
    }

    public void setClientes(ClienteSelector[] clientes) {
        this.clientes = clientes;
    }

    public Provincia[] getProvincias() {
        return provincias;
    }

    public void setProvincias(Provincia[] provincias) {
        this.provincias = provincias;
    }

    public TipoCuentaContableSelector[] getTipoCuentaContables() {
        return tipoCuentaContables;
    }

    public void setTipoCuentaContables(TipoCuentaContableSelector[] tipoCuentaContables) {
        this.tipoCuentaContables = tipoCuentaContables;
    }

}
