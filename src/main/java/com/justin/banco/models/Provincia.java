package com.justin.banco.models;

import java.util.List;

 

// @Entity
public class Provincia {

    // @Id
    private Integer codigoProvincia;
    private String nombre;
    private List<Canton> cantones;

    public Provincia() {
    }

    public Integer getCodigoProvincia() {
        return codigoProvincia;
    }

    public void setCodigoProvincia(Integer codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Canton> getCantones() {
        return cantones;
    }

    public void setCantones(List<Canton> cantones) {
        this.cantones = cantones;
    }

}
