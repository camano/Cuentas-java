package com.jonathan.rest.deudaservice.dto;



public class ErrorDetalles {
	
	private String mensaje;
	

	public ErrorDetalles( String mensaje) {
		super();		
		this.mensaje = mensaje;		
	}
	

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	

}
