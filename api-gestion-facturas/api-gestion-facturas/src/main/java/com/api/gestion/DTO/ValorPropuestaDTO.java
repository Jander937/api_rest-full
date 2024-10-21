package com.api.gestion.DTO;

import com.api.gestion.entities.PropuestaEntity;
import lombok.Data;

@Data
public class ValorPropuestaDTO {
    private Integer id;

    private PropuestaEntity propuestaEntity;

    private Double monto_total_propuesta;

    private Double aporte_comfama;

}
