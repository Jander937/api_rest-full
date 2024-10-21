package com.api.gestion.services;

import com.api.gestion.DTO.RepresentanteDTO;
import com.api.gestion.entities.RepresentanteEntity;
import java.util.List;
import java.util.Map;

public interface RepresentanteServicio {

    RepresentanteDTO agregarRepresentante(RepresentanteEntity datosRepresentante) throws Exception;

    RepresentanteDTO buscarRepresentantePorId(Integer id) throws Exception;

    List<RepresentanteDTO> buscarTodosLosRepresentantes() throws Exception;


    RepresentanteDTO modificarRepresentante(Integer id, RepresentanteEntity representante) throws Exception;

    Boolean eliminaRepresentante(Integer id);

}
