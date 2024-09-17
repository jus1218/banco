package com.justin.banco.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;


@Entity
public class Cliente {
    @Id
    private BigDecimal codigoCliente;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Column(name = "cedula")
    private BigDecimal cedula;
    @Column(name = "direccion_exacta")
    private String direccionExacta;
    @Column(name = "distrito")
    private int distrito;

    public Cliente(){
        
    }

    public Cliente(BigDecimal codigoCliente, String nombre, String primerApellido, String segundoApellido,
            BigDecimal cedula, String direccionExacta, int distrito) {
        this.codigoCliente = codigoCliente;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.cedula = cedula;
        this.direccionExacta = direccionExacta;
        this.distrito = distrito;
    }
    public BigDecimal getCodigoCliente() {
        return codigoCliente;
    }
    public void setCodigoCliente(BigDecimal codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPrimerApellido() {
        return primerApellido;
    }
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }
    public String getSegundoApellido() {
        return segundoApellido;
    }
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
    public BigDecimal getCedula() {
        return cedula;
    }
    public void setCedula(BigDecimal cedula) {
        this.cedula = cedula;
    }
    public String getDireccionExacta() {
        return direccionExacta;
    }
    public void setDireccionExacta(String direccionExacta) {
        this.direccionExacta = direccionExacta;
    }
    public int getDistrito() {
        return distrito;
    }
    public void setDistrito(int distrito) {
        this.distrito = distrito;
    }

    
}
