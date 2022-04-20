package com.jonathan.rest.deudaservice.utils;

import com.jonathan.rest.deudaservice.dto.DeudaDto;
import com.jonathan.rest.deudaservice.entity.Deuda;

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

}
