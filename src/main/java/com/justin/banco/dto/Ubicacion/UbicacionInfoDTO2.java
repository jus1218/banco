package com.justin.banco.dto.Ubicacion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UbicacionInfoDTO2 {
    @Id
    @Column
    private String codigo;

    @Column
    private String nombre;
    @Column(name = "id_relacion")
    private Integer idRelacion;

    public UbicacionInfoDTO2() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdRelacion() {
        return idRelacion;
    }

    public void setIdRelacion(Integer idRelacion) {
        this.idRelacion = idRelacion;
    }

}
