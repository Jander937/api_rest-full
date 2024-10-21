package com.api.gestion.mapa;

import com.api.gestion.DTO.ProponenteDTO;
import com.api.gestion.entities.ProponenteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProponenteMapa {
    @Mappings({
            @Mapping(source = "proponente_id", target = "proponente_id"),
            @Mapping(source = "nombre_proponente", target = "nombre_proponente"),
            @Mapping(source = "tipoProponenteEntity", target = "tipoProponenteEntity"),
            @Mapping(source = "representanteEntity", target = "representanteEntity"),
            @Mapping(source = "trayectoria", target = "trayectoria"),
    })
    ProponenteDTO proponenteToDTO(ProponenteEntity proponente);

    List<ProponenteDTO> toDTOList(List<ProponenteEntity> proponenteDTOS);
}
