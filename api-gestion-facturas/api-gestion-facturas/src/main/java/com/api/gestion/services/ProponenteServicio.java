package com.api.gestion.services;

import com.api.gestion.DTO.ProponenteDTO;
import com.api.gestion.entities.ProponenteEntity;

import java.util.List;

public interface ProponenteServicio {

    ProponenteDTO agregarProponente(ProponenteEntity datosProponente) throws Exception;

    ProponenteDTO buscarProponentePorId(Integer id) throws Exception;

    List<ProponenteDTO> buscarTodosProponente() throws Exception;

    ProponenteDTO modificarProponente(Integer id, ProponenteEntity Proponente) throws Exception;

    Boolean eliminaProponente(Integer id);
}
