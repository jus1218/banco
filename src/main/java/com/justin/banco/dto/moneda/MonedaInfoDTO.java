package com.justin.banco.dto.moneda;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MonedaInfoDTO {

    @Id
    @Column(name = "codigo_moneda")
    private String codigoMoneda;

    @Column(name = "nombre")
    private String nombre;

    public MonedaInfoDTO() {
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
