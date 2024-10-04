package com.justin.banco.models;

 
// @Table(name = "distrito")
// @Entity

public class Distrito {
    // @Id
    // @Column(name = "codigo_distrito")
    // @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer codigoDistrito;
    // @Column(name = "nombre")
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
