package com.jonathan.service.usuarioservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jonathan.service.usuarioservice.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/search/{username}")
    public ResponseEntity<?>searchUsuario(@PathVariable("username") String username){
    	return new ResponseEntity<>(usuarioService.getUsuarioUsername(username), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<?>listarUsuario(){
        return new ResponseEntity<>(usuarioService.getUsuario(),HttpStatus.ACCEPTED);
    }
}
