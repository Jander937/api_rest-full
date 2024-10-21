package com.api.gestion.services;

import com.api.gestion.DTO.TipoProponenteDTO;
import com.api.gestion.entities.TipoProponenteEntity;

import java.util.List;

public interface TipoProponenteServicio {


    TipoProponenteDTO agregarTipoProponente(TipoProponenteEntity datosTipoDocumento) throws Exception;

    TipoProponenteDTO buscarTipoProponentePorId(Integer id) throws Exception;

    List<TipoProponenteDTO> buscarTodosTipoProponente() throws Exception;


    TipoProponenteDTO modificarTipoproponente(Integer id, TipoProponenteEntity tipoProponente) throws Exception;

    Boolean eliminaTipoProponente(Integer id);
}
