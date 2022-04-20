package com.jonathan.rest.deudaservice.excepciones;

import org.springframework.http.HttpStatus;

public class DeudasException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private HttpStatus estado;
    private String mensaje;

    public DeudasException(HttpStatus estado, String mensaje) {
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public HttpStatus getEstado() {
        return estado;
    }

    public void setEstado(HttpStatus estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
