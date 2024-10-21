package com.api.gestion.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;
@Data
@Entity
@Table(name="proponentes")
public class ProponenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer proponente_id;

    @Column(name = "nombre_proponente")
    private String nombre_proponente;

    @Column(name="trayectoria")
    private String trayectoria;

    @ManyToOne
    @JoinColumn(name="id_representante", referencedColumnName = "id_representante")
    private RepresentanteEntity representanteEntity;

   @ManyToOne
   @JoinColumn(name="id_tipo_proponente", referencedColumnName = "id_tipo_Proponente")
    private TipoProponenteEntity tipoProponenteEntity;

}
