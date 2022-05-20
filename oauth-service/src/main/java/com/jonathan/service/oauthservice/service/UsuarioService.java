package com.jonathan.service.oauthservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jonathan.service.oauthservice.clients.UsuarioClient;
import com.jonathan.service.oauthservice.dto.Usuario;

@Service
public class UsuarioService implements IUsuarioService, UserDetailsService {

	private Logger log = LoggerFactory.getLogger(UsuarioService.class);

	@Autowired
	private UsuarioClient client;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = client.findByUserName(username);
		if (usuario == null) {
			log.error("Hubo un error en el login el usuario " + username);
			throw new UsernameNotFoundException("Hubo un error en el login el usuario " + username);
		}
		List<String> roles = Arrays.asList("ROLE_USER", "ROLE_ADMIN");
		List<GrantedAuthority> authorities = roles.stream().map(SimpleGrantedAuthority::new)
				.peek(authority -> log.info("Roles " + authority)).collect(Collectors.toList());
		log.info("El usuario logeado es " + usuario);
		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, authorities);
	}

	@Override
	public Usuario findByUserName(String username) {
		Usuario usuario = client.findByUserName(username);
		return usuario;
	}

}
