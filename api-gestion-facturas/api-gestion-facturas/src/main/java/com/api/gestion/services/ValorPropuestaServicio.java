package com.api.gestion.services;

import com.api.gestion.DTO.ValorPropuestaDTO;
import com.api.gestion.entities.ValorPropuestaEntity;

import java.util.List;

public interface ValorPropuestaServicio {

    ValorPropuestaDTO agregarValorPropuesta(ValorPropuestaEntity datosTipoDocumento) throws Exception;

    ValorPropuestaDTO buscarValorPropuestaPorId(Integer id) throws Exception;

    List<ValorPropuestaDTO> buscarTodosValorPropuesta() throws Exception;


    ValorPropuestaDTO modificarValorPropuesta(Integer id, ValorPropuestaEntity valorPropuesta) throws Exception;

    Boolean eliminarValorPropuesta(Integer id);
}
