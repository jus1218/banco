package com.justin.banco.dto.telefono;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TelefonoInfoDTO {
    @Id
    @Column(name = "codigo_telefono")
    private Integer codigoTelefono;
    @Column(name = "numero")
    private String numero;
    @Column(name = "codigo_banco")
    private String codigoBanco;
    @Column(name = "codigo_cliente")
    private Integer codigoCliente;

    
    public TelefonoInfoDTO() {
    }
    public Integer getCodigoTelefono() {
        return codigoTelefono;
    }
    public void setCodigoTelefono(Integer codigoTelefono) {
        this.codigoTelefono = codigoTelefono;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getCodigoBanco() {
        return codigoBanco;
    }
    public void setCodigoBanco(String codigoBanco) {
        this.codigoBanco = codigoBanco;
    }
    public Integer getCodigoCliente() {
        return codigoCliente;
    }
    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

 

}
