package com.jonathan.rest.deudaservice.excepciones;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.jonathan.rest.deudaservice.dto.ErrorDetalles;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DeudasException.class)
	public ResponseEntity<ErrorDetalles> manejarBlogAppException(DeudasException exception, WebRequest webRequest) {
		ErrorDetalles errorDetalles = new ErrorDetalles(exception.getMensaje());
		return new ResponseEntity<>(errorDetalles, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetalles> manejarGlobalException(Exception exception, WebRequest webRequest) {
		ErrorDetalles errorDetalles = new ErrorDetalles(exception.getMessage());
		return new ResponseEntity<>(errorDetalles, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> errores = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String nombreCampo = ((FieldError) error).getField();
			String mensaje = error.getDefaultMessage();

			errores.put(nombreCampo, mensaje);
		});

		return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<ErrorDetalles> invalidFormatException(final InvalidFormatException e) {
        ErrorDetalles errorDetalles = new ErrorDetalles(e.getMessage());
		return new ResponseEntity<>(errorDetalles, HttpStatus.BAD_REQUEST);
    }

}
