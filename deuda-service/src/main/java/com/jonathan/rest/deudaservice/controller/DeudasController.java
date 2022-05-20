package com.jonathan.rest.deudaservice.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import com.jonathan.rest.deudaservice.dto.DeudaDto;
import com.jonathan.rest.deudaservice.service.DeudaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeudasController {

	@Autowired
	private DeudaService deudaService;

	@GetMapping("/listar")
	public ResponseEntity<?> listarDeudas() {
		return new ResponseEntity<>(deudaService.listarDeudas(), HttpStatus.OK);
	}

	@PostMapping("/addDeuda")
	public ResponseEntity<?> guardarDeuda(@Valid @RequestBody DeudaDto deudaDto) {
		Map<String, Object> mensaje = new HashMap<>();
		DeudaDto respuesta = deudaService.addDeuda(deudaDto);
		if (respuesta == null) {
			mensaje.put("Mensaje  ", "No se pudo crear la deuda");
			return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
		}
		mensaje.put("Mensaje", "Se creo la deuda");
		mensaje.put("Deuda", deudaDto);
		return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
	}

	@PutMapping("/updateDeuda/:id")
	public ResponseEntity<?> editarDeuda(@PathVariable("id") int id, @RequestBody DeudaDto deudaDto) {
		return null;
	}

	@DeleteMapping("/deleteDeuda/:id")
	public ResponseEntity<?> eliminarDeuda(@PathVariable("id") String id) {
		return null;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getDeudaId(@PathVariable("id") int id) {
		return new ResponseEntity<>(deudaService.getDeudaxId(id), HttpStatus.OK);
	}

}
