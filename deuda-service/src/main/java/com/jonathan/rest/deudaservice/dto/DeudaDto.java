package com.jonathan.rest.deudaservice.dto;

import java.util.HashSet;
import java.util.Set;

public class DeudaDto {

    private long id;
    private String descripcion;
    private Double valor;
    

    public DeudaDto() {
    }

    public DeudaDto(String descripcion, Double valor) {
        this.descripcion = descripcion;
        this.valor = valor;        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    

}
