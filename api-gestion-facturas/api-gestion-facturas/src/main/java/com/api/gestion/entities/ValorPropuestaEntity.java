package com.api.gestion.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "valor_propuesta")
public class ValorPropuestaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_propuesta", referencedColumnName = "id_propuesta")
    private PropuestaEntity propuestaEntity;

    @Column(name="monto_total_propuesta")
    private Double monto_total_propuesta;

    @Column(name="aporte_comfama")
    private Double aporte_comfama;

}
