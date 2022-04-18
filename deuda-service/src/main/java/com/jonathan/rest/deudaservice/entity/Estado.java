package com.jonathan.rest.deudaservice.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "estado")
public class Estado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;

    public Estado(String nombre) {
        this.nombre = nombre;
    }

    public Estado() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return "Estado [id=" + id + ", nombre=" + nombre + "]";
    }

}
