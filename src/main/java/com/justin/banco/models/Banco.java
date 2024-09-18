package com.justin.banco.models;

// @Entity
public class Banco {

    // @Id
    private String codigoBanco;
    // @Column(name = "nombre")
    private String nombre;
    // @Column(name = "codigo_moneda")
    private Moneda moneda;
    // @Column(name = "codigo_distrito")
    private Distrito distrito;
    // @Column(name = "direccion_exacta")
    private String direccionExacta;

    public Banco() {

    }

    public Banco(String codigoBanco, String nombre, Moneda moneda, Distrito distrito, String direccionExacta) {
        this.codigoBanco = codigoBanco;
        this.nombre = nombre;
        this.moneda = moneda;
        this.distrito = distrito;
        this.direccionExacta = direccionExacta;
    }

    public String getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(String codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccionExacta() {
        return direccionExacta;
    }

    public void setDireccionExacta(String direccionExacta) {
        this.direccionExacta = direccionExacta;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

}
