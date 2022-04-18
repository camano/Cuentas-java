package com.jonathan.rest.deudaservice.dto;

public class EstadoDto {

    private long id;
    private String nombre;

    public EstadoDto() {
    }

    public EstadoDto(String nombre) {
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "EstadoDto [id=" + id + ", nombre=" + nombre + "]";
    }

}
