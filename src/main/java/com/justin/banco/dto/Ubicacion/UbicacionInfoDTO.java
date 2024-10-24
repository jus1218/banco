package com.justin.banco.dto.Ubicacion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UbicacionInfoDTO {
    @Id
    @Column
    private Integer codigo;

    @Column
    private String nombre; 
    @Column(name = "id_relacion", nullable = true)
    private Integer idRelacion;

    
    public UbicacionInfoDTO(Integer codigo, String nombre, Integer idRelacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.idRelacion = idRelacion;
    }

    public UbicacionInfoDTO() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
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
