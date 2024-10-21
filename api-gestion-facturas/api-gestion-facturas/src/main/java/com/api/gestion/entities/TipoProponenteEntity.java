package com.api.gestion.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tipos_proponente")
public class TipoProponenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipo_proponente;

    @Column(name = "tipo_proponente")
    private String tipo_proponente;

}
