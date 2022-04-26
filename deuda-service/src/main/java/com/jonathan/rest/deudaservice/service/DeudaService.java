package com.jonathan.rest.deudaservice.service;

import java.util.List;

import com.jonathan.rest.deudaservice.dto.DeudaDto;
import com.jonathan.rest.deudaservice.entity.Deuda;

public interface DeudaService {

    public List<Deuda> listarDeudas();

    public DeudaDto addDeuda(DeudaDto deudaDto);

    public DeudaDto updateDeuda(DeudaDto deudaDto);

    public void deleteDeuda(int id);

    public DeudaDto getDeudaxId(int id);

}
