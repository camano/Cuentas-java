package com.jonathan.rest.deudaservice.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Deuda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private Double valor;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "estado_id", nullable = false)
    private Estado estado;

    public Deuda() {
    }

    public Deuda(String descripcion, Double valor, Estado estado) {
        this.descripcion = descripcion;
        this.valor = valor;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Deuda [descripcion=" + descripcion + ", estado=" + estado + ", id=" + id + ", valor=" + valor + "]";
    }

}
