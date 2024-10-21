package com.api.gestion.mapa;

import com.api.gestion.DTO.ValorPropuestaDTO;
import com.api.gestion.entities.ValorPropuestaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IValorPropuestaMapa {
    @Mappings({
            @Mapping(source = "propuestaEntity", target = "propuestaEntity"),
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "aporte_comfama", target = "aporte_comfama"),
            @Mapping(source = "monto_total_propuesta", target = "monto_total_propuesta")

    })
    ValorPropuestaDTO valorToDTO(ValorPropuestaEntity valorPropuesta);

    List<ValorPropuestaDTO> toDTOList(List<ValorPropuestaEntity> valorPropuestaList);
}
