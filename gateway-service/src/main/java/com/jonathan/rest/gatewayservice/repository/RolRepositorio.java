package com.jonathan.rest.gatewayservice.repository;

import java.util.Optional;

import com.jonathan.rest.gatewayservice.entity.Rol;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepositorio extends JpaRepository<Rol, Long> {

	public Optional<Rol> findByNombre(String nombre);

}
