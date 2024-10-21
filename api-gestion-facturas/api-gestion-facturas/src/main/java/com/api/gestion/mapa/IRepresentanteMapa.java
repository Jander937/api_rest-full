package com.api.gestion.mapa;

import com.api.gestion.DTO.RepresentanteDTO;
import com.api.gestion.entities.RepresentanteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IRepresentanteMapa {
    @Mappings({
            @Mapping(source="tipo_documento.id_tipo_documento", target="tipo_documento"),
            @Mapping(source="correo", target= "correo"),
            @Mapping(source="telefono_celular", target="telefono_celular"),
            @Mapping(source="telefono_fijo", target="telefono_fijo"),
            @Mapping(source="primer_nombre", target="primer_nombre"),
            @Mapping(source="primer_apellido", target="primer_apellido"),
            @Mapping(source="numero_documento", target="numero_documento"),

    })
    RepresentanteDTO representanteToDTO(RepresentanteEntity representante);

    List<RepresentanteDTO> toDtoList(List<RepresentanteEntity> representanteList);
}
