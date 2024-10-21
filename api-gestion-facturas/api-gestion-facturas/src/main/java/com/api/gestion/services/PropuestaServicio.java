package com.api.gestion.services;

import com.api.gestion.DTO.PropuestaDTO;
import com.api.gestion.entities.PropuestaEntity;

import java.util.List;

public interface PropuestaServicio {

    PropuestaDTO guardarPropuesta(PropuestaEntity datosPropuesta)throws Exception;

    PropuestaDTO buscarPropuesta(Integer id) throws Exception;

    List<PropuestaDTO> buscarTodasLasPropuestas()throws Exception;


    PropuestaDTO modificarPropuesta(Integer id, PropuestaEntity propuesta) throws Exception;

    Boolean eliminarPropuesta(Integer id);
}
