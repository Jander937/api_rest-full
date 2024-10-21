package com.api.gestion.mapa;
import com.api.gestion.DTO.PropuestaDTO;
import com.api.gestion.entities.PropuestaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPropuestaMapa {
    @Mappings({
            @Mapping(source = "id_propuesta", target = "id_propuesta"),
            @Mapping(source = "nombre_propuesta", target = "nombre_propuesta")
    })
    PropuestaDTO propuestaToDTO(PropuestaEntity propuesta);

    List<PropuestaDTO> toDtoList(List<PropuestaEntity> propuestaList);
}
