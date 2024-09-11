package com.justin.banco.models;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity; 
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "moneda")
public class Moneda {

    // @Id
    // @Column(name = "codigo_moneda") 
    private String codigoMoneda;

    // @Column(name = "nombre")
    private String nombre;
    
    public Moneda(String codigoMoneda, String nombre) {
        this.codigoMoneda = codigoMoneda;
        this.nombre = nombre;
    }

    public String getCodigoMoneda() {
        return codigoMoneda;
    }

    public void setCodigoMoneda(String codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
