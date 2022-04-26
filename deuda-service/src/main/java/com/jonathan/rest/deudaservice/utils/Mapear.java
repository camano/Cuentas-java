package com.jonathan.rest.deudaservice.utils;

import com.jonathan.rest.deudaservice.dto.DeudaDto;
import com.jonathan.rest.deudaservice.dto.EstadoDto;
import com.jonathan.rest.deudaservice.entity.Deuda;
import com.jonathan.rest.deudaservice.entity.Estado;

public class Mapear {

    public static DeudaDto mapearEntidadDeuda(Deuda deuda) {
        DeudaDto deudaDto = new DeudaDto();
        deudaDto.setId(deuda.getId());
        deudaDto.setDescripcion(deuda.getDescripcion());
        deudaDto.setValor(deuda.getValor());
        return deudaDto;
    }

    public static Deuda mapearDtoDeuda(DeudaDto deudaDto) {
        Deuda deuda = new Deuda();
        deuda.setId(deudaDto.getId());
        deuda.setDescripcion(deudaDto.getDescripcion());
        deuda.setValor(deudaDto.getValor());
        return deuda;
    }

    public static EstadoDto mapearEstadoDto(Estado estado) {
        EstadoDto estadoDto = new EstadoDto();
        estadoDto.setId(estado.getId());
        estadoDto.setNombre(estado.getNombre());
        return estadoDto;
    }

    public static Estado mapearEstado(EstadoDto estadoDto) {
        Estado estado = new Estado();
        estado.setId(estadoDto.getId());
        estado.setNombre(estadoDto.getNombre());
        return estado;
    }

}
