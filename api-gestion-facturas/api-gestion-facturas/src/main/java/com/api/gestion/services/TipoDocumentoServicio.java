package com.api.gestion.services;

import com.api.gestion.DTO.TipoDocumentoDTO;
import com.api.gestion.entities.TipoDocumentoEntity;


import java.util.List;

public interface TipoDocumentoServicio {
    //Rutina para guardar en BD un tipoDocumento

    //Rutina para guardar en BD un tipoDocumento
    TipoDocumentoDTO agregarTipODocumento(TipoDocumentoEntity datosTipoDocumento) throws Exception;

    //RUTINA PARA BUSCAR UN ELEMENTO DENTRO BD POR ID
    TipoDocumentoDTO buscarTipoDocumentoPorId(Integer id) throws Exception;

    List<TipoDocumentoDTO> buscarTodosTiposDocumentos() throws Exception;

    TipoDocumentoDTO modificarTipoDocumento(Integer id, TipoDocumentoEntity tipoDocumento) throws Exception;

    Boolean eliminaTipoDocumento(Integer id);
}
