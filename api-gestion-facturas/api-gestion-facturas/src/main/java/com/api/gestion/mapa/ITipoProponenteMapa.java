package com.api.gestion.mapa;

import com.api.gestion.DTO.TipoProponenteDTO;
import com.api.gestion.entities.TipoProponenteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITipoProponenteMapa {

    @Mappings({
            @Mapping(source = "id_tipo_proponente", target = "id_tipo_proponente"),
            @Mapping(source="tipo_proponente",target="tipo_proponente")
    })
    TipoProponenteDTO tipoproponenteToDTO(TipoProponenteEntity tipoProponente);

    List<TipoProponenteDTO> toDtoList(List<TipoProponenteEntity> tipoProponenteList);
}
