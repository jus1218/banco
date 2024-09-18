package com.justin.banco.dto.cliente;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// public class ClienteInfoDTO {

//     private Integer codigoCliente; 
//     private String nombre; 
//     private String primerApellido; 
//     private String segundoApellido; 
//     private BigDecimal cedula; 
//     private String direccionExacta; 
//     private int distrito;

//     public ClienteInfoDTO() {

//     }

//     public ClienteInfoDTO(Integer codigoCliente, String nombre, String primerApellido, String segundoApellido,
//             BigDecimal cedula, String direccionExacta, int distrito) {
//         this.codigoCliente = codigoCliente;
//         this.nombre = nombre;
//         this.primerApellido = primerApellido;
//         this.segundoApellido = segundoApellido;
//         this.cedula = cedula;
//         this.direccionExacta = direccionExacta;
//         this.distrito = distrito;
//     }

//     public String getNombre() {
//         return nombre;
//     }

//     public void setNombre(String nombre) {
//         this.nombre = nombre;
//     }

//     public String getPrimerApellido() {
//         return primerApellido;
//     }

//     public void setPrimerApellido(String primerApellido) {
//         this.primerApellido = primerApellido;
//     }

//     public String getSegundoApellido() {
//         return segundoApellido;
//     }

//     public void setSegundoApellido(String segundoApellido) {
//         this.segundoApellido = segundoApellido;
//     }

//     public BigDecimal getCedula() {
//         return cedula;
//     }

//     public void setCedula(BigDecimal cedula) {
//         this.cedula = cedula;
//     }

//     public String getDireccionExacta() {
//         return direccionExacta;
//     }

//     public void setDireccionExacta(String direccionExacta) {
//         this.direccionExacta = direccionExacta;
//     }

//     public int getDistrito() {
//         return distrito;
//     }

//     public void setDistrito(int distrito) {
//         this.distrito = distrito;
//     }

//     public Integer getCodigoCliente() {
//         return codigoCliente;
//     }

//     public void setCodigoCliente(Integer codigoCliente) {
//         this.codigoCliente = codigoCliente;
//     }

// }
@Entity
public class ClienteInfoDTO {
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
    @Column(name = "codigo_distrito")
    private Integer codigoDistrito;

    public ClienteInfoDTO() {

    }

    public ClienteInfoDTO(BigDecimal codigoCliente, String nombre, String primerApellido, String segundoApellido,
            BigDecimal cedula, String direccionExacta, Integer codigoDistrito) {
        this.codigoCliente = codigoCliente;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.cedula = cedula;
        this.direccionExacta = direccionExacta;
        this.codigoDistrito = codigoDistrito;
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

    public Integer getCodigoDistrito() {
        return codigoDistrito;
    }

    public void setCodigoDistrito(Integer codigoDistrito) {
        this.codigoDistrito = codigoDistrito;
    }

}
