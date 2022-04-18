package com.jonathan.rest.deudaservice.controller;

import java.util.HashMap;
import java.util.Map;

import com.jonathan.rest.deudaservice.dto.DeudaDto;
import com.jonathan.rest.deudaservice.service.DeudaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deudas")
public class DeudasController {

    @Autowired
    private DeudaService deudaService;

    @GetMapping
    public ResponseEntity<?> listarDeudas() {
        return new ResponseEntity<>(deudaService.listarDeudas(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> guardarDeuda(@RequestBody DeudaDto deudaDto) {
        Map<String, Object> mensaje = new HashMap<>();        
        DeudaDto respuesta = deudaService.addDeuda(deudaDto);        
        if (respuesta == null) {
            mensaje.put("Mensaje ", "No se pudo crear");
            return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
        }
        mensaje.put("Mensaje", "Se creo la deuda");
        mensaje.put("Deuda", deudaDto);
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

}
