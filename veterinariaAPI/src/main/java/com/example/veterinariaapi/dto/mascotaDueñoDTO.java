package com.example.veterinariaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class mascotaDueñoDTO {
    private String nombreMascota;
    private String especie;
    private String raza;
    private String nombreDueño;
    private String apellidoDueño;
}
