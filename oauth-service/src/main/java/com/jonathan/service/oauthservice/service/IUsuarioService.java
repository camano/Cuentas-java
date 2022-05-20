package com.jonathan.service.oauthservice.service;

import com.jonathan.service.oauthservice.dto.Usuario;

public interface IUsuarioService {
	public Usuario findByUserName(String username);
}
