package com.api.gestion.entities;
import com.api.gestion.helpers.Estados;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "propuestas")
public class PropuestaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_propuesta;

    @ManyToOne
    @JoinColumn(name="id_proponente", referencedColumnName = "proponente_id")
    private ProponenteEntity proponenteEntity;

    @Column(name="nombre_propuesta")
    private String nombre_propuesta;

    @Column(name="descripcion_actividades")
    private String descripcion_actividades;

    @Column(name="descripcion_propuesta")
    private String descripcion_propuesta;

    @Column(name = "fecha_presentacion")
    private LocalDate fecha_presentacion;

    @Column(name="publico_beneficiado")
    private String publico_beneficiado;

    @Column(name = "empresas_aliadas")
    private String empresas_aliadas;


    private Estados estado_propuesta=Estados.INICIAL;

    @Column(name="fecha_inicio_evento")
    private LocalDate fecha_inicio_evento;
}
