package com.api.gestion.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private Integer id;
    private String name;
    private String contactNumber;
    private String email; // Cambiado de correo a email
    private String password;
    private String status; // Cambiado de status a estado
    private String role;
}
