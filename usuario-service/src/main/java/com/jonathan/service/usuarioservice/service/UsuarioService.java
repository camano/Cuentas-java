package com.jonathan.service.usuarioservice.service;

import com.jonathan.service.usuarioservice.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    public Usuario getUsuarioUsername(String username);

    public List<Usuario>getUsuario();

    public void eliminarUsuario(Integer id);
}
