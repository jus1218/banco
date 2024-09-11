package com.justin.banco.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Banco {

    @Id
    private String codigoBanco; 
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "codigo_moneda")
    private String codigoMoneda; 
    @Column(name = "codigo_distrito")
    private String codigoDistrito; 
    @Column(name = "direccion_exacta")
    private String direccionExacta;

    public Banco() {

    }

    public Banco(String codigoBanco, String nombre, String codigoMoneda, String codigoDistrito,
            String direccionExacta) {
        this.codigoBanco = codigoBanco;
        this.nombre = nombre;
        this.codigoMoneda = codigoMoneda;
        this.codigoDistrito = codigoDistrito;
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

    public String getCodigoMoneda() {
        return codigoMoneda;
    }

    public void setCodigoMoneda(String codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
    }

    public String getCodigoDistrito() {
        return codigoDistrito;
    }

    public void setCodigoDistrito(String codigoDistrito) {
        this.codigoDistrito = codigoDistrito;
    }

}
