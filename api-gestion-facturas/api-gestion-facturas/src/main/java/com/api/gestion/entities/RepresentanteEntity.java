package com.api.gestion.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="representantes")
public class RepresentanteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_representante;

    @ManyToOne
    @JoinColumn(name="id_tipo_documento", referencedColumnName = "id_tipo_documento")
    private TipoDocumentoEntity tipo_documento;

    @Column(name = "numero_documento")
    private String numero_documento;

    @Column(name = "primer_nombre")
    private String primer_nombre;

    @Column(name = "primer_apellido")
    private String primer_apellido;

    @Column(name = "telefono_fijo")
    private String telefono_fijo;

    @Column(name = "telefono_celular")
    private String telefono_celular;

    @Column(name="correo")
    private String correo;

    @Column(name="estado", columnDefinition = "TINYINT")
    private Boolean status;

    @Column(name="password")
    private String password;


}
