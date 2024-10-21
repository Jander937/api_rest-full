package com.api.gestion.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="tiposDocumento")
public class TipoDocumentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipo_documento;

    @Column(name="tipo_documento")
    private String tipo_documento;

}
