package com.jonathan.rest.deudaservice.service;

import java.util.List;

import com.jonathan.rest.deudaservice.dto.DeudaDto;
import com.jonathan.rest.deudaservice.entity.Deuda;
import com.jonathan.rest.deudaservice.entity.Estado;
import com.jonathan.rest.deudaservice.repository.DeudaRepository;
import com.jonathan.rest.deudaservice.repository.EstadoRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeudaServiceImpl implements DeudaService {

    @Autowired
    private DeudaRepository deudaRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Deuda> listarDeudas() {
        return (List<Deuda>) deudaRepository.findAll();
    }

    @Override
    public DeudaDto addDeuda(DeudaDto deudaDto) {
        Deuda deuda = mapearDto(deudaDto);
        Estado estado = new Estado();
        estado.setId((long) 1);
        estado.setNombre("Pendiente");
        deuda.setEstado(estado);
        Deuda guardarDeuda = deudaRepository.save(deuda);
        return mapearEntidad(guardarDeuda);
    }

    private DeudaDto mapearEntidad(Deuda deuda) {
        return modelMapper.map(deuda, DeudaDto.class);
    }

    private Deuda mapearDto(DeudaDto deudaDto) {
        return modelMapper.map(deudaDto, Deuda.class);
    }

}
