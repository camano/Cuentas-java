package com.jonathan.rest.deudaservice.service;

import java.util.List;

import com.jonathan.rest.deudaservice.dto.DeudaDto;

import com.jonathan.rest.deudaservice.entity.Deuda;
import com.jonathan.rest.deudaservice.entity.Estado;
import com.jonathan.rest.deudaservice.repository.DeudaRepository;
import com.jonathan.rest.deudaservice.repository.EstadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeudaServiceImpl implements DeudaService {

    @Autowired
    private DeudaRepository deudaRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public List<Deuda> listarDeudas() {
        return (List<Deuda>) deudaRepository.findAll();
    }

    @Override
    public DeudaDto addDeuda(DeudaDto deudaDto) {
        Deuda deuda = mapearDto(deudaDto);

        Estado estado = estadoRepository.findById(deudaDto.getEstado()).orElse(null);

        deuda.setEstado(estado);
        Deuda guardarDeuda = deudaRepository.save(deuda);
        return mapearEntidad(guardarDeuda);
    }

    private DeudaDto mapearEntidad(Deuda deuda) {
        DeudaDto deudaDto = new DeudaDto();
        deudaDto.setId(deuda.getId());
        deudaDto.setDescripcion(deuda.getDescripcion());
        deudaDto.setValor(deuda.getValor());
        return deudaDto;
    }

    private Deuda mapearDto(DeudaDto deudaDto) {
        Deuda deuda = new Deuda();
        deuda.setId(deudaDto.getId());
        deuda.setDescripcion(deudaDto.getDescripcion());
        deuda.setValor(deudaDto.getValor());
        return deuda;
    }

}
