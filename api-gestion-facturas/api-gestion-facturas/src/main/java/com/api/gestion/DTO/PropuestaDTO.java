package com.api.gestion.DTO;


import com.api.gestion.entities.ProponenteEntity;
import com.api.gestion.helpers.Estados;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;
@Data
public class PropuestaDTO {

        private Integer id_propuesta;

        private ProponenteEntity proponenteEntity;

        private String nombre_propuesta;

        private String descripcion_actividades;


        private String descripcion_propuesta;

        private LocalDate fecha_presentacion;

        private String publico_beneficiado;

        private String empresas_aliadas;

        private Estados estado_propuesta=Estados.INICIAL;
        private LocalDate fecha_inicio_evento;


}
