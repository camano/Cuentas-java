package com.jonathan.rest.deudaservice.dto;


import javax.validation.constraints.NotNull;

public class DeudaDto {

    private Integer id;

    private String descripcion;
    @NotNull(message = "El valor no debe ser nulo")
    private Double valor;

    @NotNull(message = "El Estado no debe ser nulo")
    private Integer estado;

    private EstadoDto estadoDto;

    public DeudaDto() {
    }

    public DeudaDto(String descripcion, Double valor, Integer estado, EstadoDto estadoDto) {
        this.descripcion = descripcion;
        this.valor = valor;
        this.estado = estado;
        this.estadoDto = estadoDto;
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

    public EstadoDto getEstadoDto() {
        return estadoDto;
    }

    public void setEstadoDto(EstadoDto estadoDto) {
        this.estadoDto = estadoDto;
    }

}
