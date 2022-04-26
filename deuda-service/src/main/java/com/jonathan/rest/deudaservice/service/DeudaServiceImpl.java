package com.jonathan.rest.deudaservice.service;

import java.util.List;

import com.jonathan.rest.deudaservice.dto.DeudaDto;
import com.jonathan.rest.deudaservice.dto.EstadoDto;
import com.jonathan.rest.deudaservice.entity.Deuda;
import com.jonathan.rest.deudaservice.entity.Estado;
import com.jonathan.rest.deudaservice.excepciones.DeudasException;
import com.jonathan.rest.deudaservice.repository.DeudaRepository;
import com.jonathan.rest.deudaservice.repository.EstadoRepository;
import com.jonathan.rest.deudaservice.utils.Mapear;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class DeudaServiceImpl implements DeudaService {

    private final static Logger logger = LoggerFactory.getLogger(DeudaServiceImpl.class);

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

        Deuda deuda = Mapear.mapearDtoDeuda(deudaDto);

        Estado estado = estadoRepository.findById(deudaDto.getEstado()).orElseThrow(() -> {
            logger.error(String.format("El estado : %s no se encuentra en la base de datos", deudaDto.getEstado()));
            throw new DeudasException(HttpStatus.BAD_REQUEST,
                    String.format("El estado : %s no se encuentra en la base de datos", deudaDto.getEstado()));
        });

        deuda.setEstado(estado);
        Deuda guardarDeuda = deudaRepository.save(deuda);
        logger.info("El objecto creado es : " + guardarDeuda);
        return Mapear.mapearEntidadDeuda(guardarDeuda);

    }

    @Override
    public DeudaDto updateDeuda(DeudaDto deudaDto) {
        
        return null;
    }

    @Override
    public void deleteDeuda(int id) {
        

    }

    @Override
    public DeudaDto getDeudaxId(int id) {
        Deuda deuda = deudaRepository.findById(id).orElseThrow(() -> {
            logger.error("No se encontro esa deuda x id");
            throw new DeudasException(HttpStatus.BAD_REQUEST, "No se encontro el pedido");
        });
        EstadoDto estadoDto = Mapear.mapearEstadoDto(deuda.getEstado());
        logger.info("El objecto deuda ::: " + deuda);
        DeudaDto deudaDto = Mapear.mapearEntidadDeuda(deuda);
        deudaDto.setEstadoDto(estadoDto);
        return deudaDto;
    }

}
