package com.api.gestion.DTO;

import lombok.Data;

@Data
public class RepresentanteDTO {

    private String tipo_documento;

    private String numero_documento;

    private String primer_nombre;

    private String primer_apellido;

    private String telefono_fijo;

    private String telefono_celular;

    private String correo;

}