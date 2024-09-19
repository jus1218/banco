package com.justin.banco.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class TipoCambio {
    @Id
    @Column(name = "codigo_moneda")
    private String codigoMoneda;
    @Column(name = "fecha")
    private LocalDate fecha;
    @Column(name = "tipo_cambio_compra")
    private Double tipoCambioCompra;
    @Column(name = "tipo_cambio_venta")
    private Double tipoCambioVenta;
    @Column(name = "codigo_banco")
    private String codigoBanco;

    public TipoCambio() {
    }

    public String getCodigoMoneda() {
        return codigoMoneda;
    }

    public void setCodigoMoneda(String codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getTipoCambioCompra() {
        return tipoCambioCompra;
    }

    public void setTipoCambioCompra(Double tipoCambioCompra) {
        this.tipoCambioCompra = tipoCambioCompra;
    }

    public Double getTipoCambioVenta() {
        return tipoCambioVenta;
    }

    public void setTipoCambioVenta(Double tipoCambioVenta) {
        this.tipoCambioVenta = tipoCambioVenta;
    }

    public String getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(String codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

}
