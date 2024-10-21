package com.api.gestion.mapa;

import com.api.gestion.DTO.TipoDocumentoDTO;
import com.api.gestion.entities.TipoDocumentoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITipoDocumentoMapa {
    @Mappings(
            {
                    @Mapping(source = "id_tipo_documento", target = "id"),
                    @Mapping(source = "tipo_documento", target = "tipoDocumento")
            }
    )
    TipoDocumentoDTO tipoDocumentoTODTO(TipoDocumentoEntity tipoDocumento);

    List<TipoDocumentoDTO> toDtoList(List<TipoDocumentoEntity> tipoDocumentoList);

}
