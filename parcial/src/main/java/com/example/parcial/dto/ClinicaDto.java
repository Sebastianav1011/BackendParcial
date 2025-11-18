package com.example.parcial.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClinicaDto {

    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String ciudad;
    private String email;
    private Integer cantidadCamas;
}
