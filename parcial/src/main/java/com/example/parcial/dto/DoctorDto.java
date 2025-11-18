package com.example.parcial.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DoctorDto {

    private Long id;
    private String nombre;
    private String especialidad;
    private String email;
    private String telefono;
    private LocalDate fechaContratacion;
    private Long clinicaId;
}
