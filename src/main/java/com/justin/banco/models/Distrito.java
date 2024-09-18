package com.justin.banco.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// @Table(name = "distrito")
@Entity

public class Distrito {
    @Id
    @Column(name = "codigo_distrito")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer codigoDistrito;
    @Column(name = "nombre")
    private String nombre;

    public Distrito() {
    }

    public Distrito(Integer codigoDistrito, String nombre) {
        this.codigoDistrito = codigoDistrito;
        this.nombre = nombre;
    }

    public Integer getCodigoDistrito() {
        return codigoDistrito;
    }

    public void setCodigoDistrito(Integer id) {
        this.codigoDistrito = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
