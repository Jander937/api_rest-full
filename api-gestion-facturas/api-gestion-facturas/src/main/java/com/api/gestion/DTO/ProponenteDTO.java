package com.api.gestion.DTO;


import com.api.gestion.entities.RepresentanteEntity;
import com.api.gestion.entities.TipoProponenteEntity;
import lombok.Data;


@Data
public class ProponenteDTO {
    private Integer proponente_id;

    private String nombre_proponente;

    private String trayectoria;

    private TipoProponenteEntity tipoProponenteEntity;

    private RepresentanteEntity representanteEntity;
}
