package com.jonathan.rest.deudaservice.dto;

import java.util.HashSet;
import java.util.Set;

public class DeudaDto {

    private Integer id;
    private String descripcion;
    private Double valor;
    private Integer estado;

    public DeudaDto() {
    }

    public DeudaDto(String descripcion, Double valor, Integer estado) {
        this.descripcion = descripcion;
        this.valor = valor;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

}
