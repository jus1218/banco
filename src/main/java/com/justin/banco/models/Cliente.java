package com.justin.banco.models;

// @Entity
public class Cliente {
    // @Id
    private Integer codigoCliente;
    // @Column(name = "nombre")
    private String nombre;
    // @Column(name = "primer_apellido")
    private String primerApellido;
    // @Column(name = "segundo_apellido")
    private String segundoApellido;
    // @Column(name = "cedula")
    private Integer cedula;
    // @Column(name = "direccion_exacta")
    private String direccionExacta;

    // @ManyToOne
    // @JoinColumn(name = "codigo_distrito", referencedColumnName =
    // "codigo_distrito")
    private Distrito distrito;

    public Cliente() {

    }

    public Cliente(Integer codigoCliente, String nombre, String primerApellido, String segundoApellido, Integer cedula,
            String direccionExacta, Distrito distrito) {
        this.codigoCliente = codigoCliente;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.cedula = cedula;
        this.direccionExacta = direccionExacta;
        this.distrito = distrito;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
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

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getDireccionExacta() {
        return direccionExacta;
    }

    public void setDireccionExacta(String direccionExacta) {
        this.direccionExacta = direccionExacta;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

}
