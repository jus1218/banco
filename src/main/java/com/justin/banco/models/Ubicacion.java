package com.justin.banco.models;

public class Ubicacion {

    private String codigo;
    private Integer type;

    

    public Ubicacion(String codigo, Integer type) {
        this.codigo = codigo;
        this.type = type;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
