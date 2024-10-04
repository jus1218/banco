package com.justin.banco.models;

import java.util.List;
 

// @Entity
public class Canton {
    // @Id
    public Integer codigoCanton;

    public String nombre;

    public List<Distrito> distritos;

    public Canton() {
    }

    public Integer getCodigoCanton() {
        return codigoCanton;
    }

    public void setCodigoCanton(Integer codigoCanton) {
        this.codigoCanton = codigoCanton;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Distrito> getDistritos() {
        return distritos;
    }

    public void setDistritos(List<Distrito> distritos) {
        this.distritos = distritos;
    }

}
