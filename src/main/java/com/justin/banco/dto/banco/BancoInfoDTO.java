package com.justin.banco.dto.banco;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BancoInfoDTO {

        @Id
        private String codigoBanco;
        @Column(name = "nombre")
        private String nombre;
        @Column(name = "codigo_moneda")
        private String codigoMoneda;
        @Column(name = "codigo_distrito")
        private Integer codigoDistrito;
        @Column(name = "direccion_exacta")
        private String direccionExacta;


        // private List<Telefono> telefonos;
        public BancoInfoDTO() {
        }

        public String getCodigoBanco() {
                return codigoBanco;
        }

        public void setCodigoBanco(String codigoBanco) {
                this.codigoBanco = codigoBanco;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public String getCodigoMoneda() {
                return codigoMoneda;
        }

        public void setCodigoMoneda(String codigoMoneda) {
                this.codigoMoneda = codigoMoneda;
        }

        public int getCodigoDistrito() {
                return codigoDistrito;
        }

        public void setCodigoDistrito(int codigoDistrito) {
                this.codigoDistrito = codigoDistrito;
        }

        public String getDireccionExacta() {
                return direccionExacta;
        }

        public void setDireccionExacta(String direccionExacta) {
                this.direccionExacta = direccionExacta;
        }

}
