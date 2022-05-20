package com.jonathan.service.oauthservice.clients;

import com.jonathan.service.oauthservice.dto.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "usuario-service")
public interface UsuarioClient {
	@GetMapping("/search")
	public Usuario findByUserName(@RequestParam(name = "username") String username);

	@GetMapping("/api/usuario")
	public List<Usuario> listar();
}
