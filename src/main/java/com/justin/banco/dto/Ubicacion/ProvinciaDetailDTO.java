package com.justin.banco.dto.Ubicacion;

public class ProvinciaDetailDTO {

    private Integer codigoProvincia;
    private String nombre;
    private Integer CantidadBancos;
    private Integer CantidadClientes;

    public ProvinciaDetailDTO() {
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

    public Integer getCantidadBancos() {
        return CantidadBancos;
    }

    public void setCantidadBancos(Integer cantidadBancos) {
        CantidadBancos = cantidadBancos;
    }

    public Integer getCantidadClientes() {
        return CantidadClientes;
    }

    public void setCantidadClientes(Integer cantidadClientes) {
        CantidadClientes = cantidadClientes;
    }

}
