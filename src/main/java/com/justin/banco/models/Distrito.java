package com.justin.banco.models;
 

// @Entity
// @Table(name = "distrito")
public class Distrito {
    // @Id
    // @Column(name = "codigo_distrito")
    private int codigoDistrito;
    // @Column(name = "nombre")
    private String nombre;

    public Distrito(int codigoDistrito, String nombre) {
        this.codigoDistrito = codigoDistrito;
        this.nombre = nombre;
    }

    public int getCodigoDistrito() {
        return codigoDistrito;
    }

    public void setCodigoDistrito(int id) {
        this.codigoDistrito = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
