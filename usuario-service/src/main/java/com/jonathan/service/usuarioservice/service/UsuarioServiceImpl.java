package com.jonathan.service.usuarioservice.service;

import com.jonathan.service.usuarioservice.entity.Usuario;
import com.jonathan.service.usuarioservice.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario getUsuarioUsername(String username) {
        return usuarioRepository.findByUsername(username).orElse(null);
    }

    @Override
    public List<Usuario> getUsuario() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public void eliminarUsuario(Integer id) {
        System.out.println("hola guapo");
    }
}
