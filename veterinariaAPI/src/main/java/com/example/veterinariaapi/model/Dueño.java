package com.example.veterinariaapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Dueño {
    private Long id;
    private String dni;
    private String nombre;
    private String apellido;
    private String celular;
}
