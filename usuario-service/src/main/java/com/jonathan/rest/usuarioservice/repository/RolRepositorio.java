package com.jonathan.rest.usuarioservice.repository;

import java.util.Optional;

import com.jonathan.rest.usuarioservice.entity.Rol;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepositorio extends JpaRepository<Rol, Long> {

	public Optional<Rol> findByNombre(String nombre);

}
