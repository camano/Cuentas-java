package com.jonathan.rest.deudaservice.repository;

import com.jonathan.rest.deudaservice.entity.Deuda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DeudaRepository extends JpaRepository<Deuda,Long>{
    
}
