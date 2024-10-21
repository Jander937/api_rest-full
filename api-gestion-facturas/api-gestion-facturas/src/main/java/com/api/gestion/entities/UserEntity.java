package com.api.gestion.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@SuppressWarnings("ALL")

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "contactNumber")
    private String contactNumber;

    @Column(name = "email")
    private String email; // Cambiado de correo a email

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private String status; // Cambiado de status a estado

    @Column(name = "role")
    private String role;
}