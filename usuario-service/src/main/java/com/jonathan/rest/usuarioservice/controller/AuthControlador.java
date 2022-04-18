package com.jonathan.rest.usuarioservice.controller;

import java.util.HashSet;
import java.util.Set;

import com.jonathan.rest.usuarioservice.dto.LoginDTO;
import com.jonathan.rest.usuarioservice.dto.RegistroDTO;
import com.jonathan.rest.usuarioservice.dto.TokenDto;
import com.jonathan.rest.usuarioservice.entity.Rol;
import com.jonathan.rest.usuarioservice.entity.Usuario;
import com.jonathan.rest.usuarioservice.jwt.JWTAuthResonseDTO;
import com.jonathan.rest.usuarioservice.jwt.JwtTokenProvider;
import com.jonathan.rest.usuarioservice.repository.CustomUserDetailsService;
import com.jonathan.rest.usuarioservice.repository.RolRepositorio;
import com.jonathan.rest.usuarioservice.repository.UsuarioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.util.StringUtils;

@RestController
@RequestMapping("/api/auth")
public class AuthControlador {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private RolRepositorio rolRepositorio;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@PostMapping("/login")
	public ResponseEntity<JWTAuthResonseDTO> authenticateUser(@RequestBody LoginDTO loginDTO) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		// obtenemos el token del jwtTokenProvider
		String token = jwtTokenProvider.generarToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		JWTAuthResonseDTO jwtAuthResonseDTO = new JWTAuthResonseDTO(token, userDetails.getUsername(),
				userDetails.getAuthorities());

		return new ResponseEntity<>(jwtAuthResonseDTO, HttpStatus.OK);
	}

	@PostMapping("/registrar")
	public ResponseEntity<?> registrarUsuario(@RequestBody RegistroDTO registroDTO) {
		if (usuarioRepositorio.existsByUsername(registroDTO.getUsername())) {
			return new ResponseEntity<>("Ese nombre de usuario ya existe", HttpStatus.BAD_REQUEST);
		}

		if (usuarioRepositorio.existsByEmail(registroDTO.getEmail())) {
			return new ResponseEntity<>("Ese email de usuario ya existe", HttpStatus.BAD_REQUEST);
		}

		Usuario usuario = new Usuario();
		usuario.setNombre(registroDTO.getNombre());
		usuario.setUsername(registroDTO.getUsername());
		usuario.setEmail(registroDTO.getEmail());
		usuario.setPassword(passwordEncoder.encode(registroDTO.getPassword()));

		Set<Rol> roles = new HashSet<>();
		roles.add(rolRepositorio.findByNombre("ROLE_USER").get());
		if (registroDTO.getRoles().contains("admin")) {
			roles.add(rolRepositorio.findByNombre("ROLE_ADMIN").get());
		}
		usuario.setRoles(roles);
		usuarioRepositorio.save(usuario);
		return new ResponseEntity<>("Usuario registrado exitosamente", HttpStatus.OK);
	}

	@PostMapping("/validate")
	public ResponseEntity<TokenDto> validate(@RequestParam String token) {
		TokenDto tokenDto = new TokenDto();
		if (StringUtils.hasText(token) && jwtTokenProvider.validarToken(token)) {
			String username = jwtTokenProvider.obtenerUsernameDelJWT(token);
			// cargamos el usuario asociado al token
			UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
			
			if (userDetails == null) {
				return ResponseEntity.badRequest().build();
			}

			tokenDto.setToken(token);
			return ResponseEntity.ok(tokenDto);
		}
		return new ResponseEntity<TokenDto>(tokenDto, HttpStatus.BAD_GATEWAY);

	}
}
