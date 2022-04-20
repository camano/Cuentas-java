package com.jonathan.rest.deudaservice.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class DeudaDto {

    private Integer id;
    @NotEmpty(message = "La descripcion  no debe estar vacio o nulo")
    private String descripcion;
    @NotNull(message = "El valor no debe ser nulo")    
    private Double valor;

    @NotNull(message = "El Estado no debe ser nulo")    
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
