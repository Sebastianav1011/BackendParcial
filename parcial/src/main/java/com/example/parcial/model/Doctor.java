package com.example.parcial.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "doctores")
@Getter
@Setter
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String especialidad;

    private String email;

    private String telefono;

    @Column(name = "fecha_contratacion")
    private LocalDate fechaContratacion;

    @ManyToOne
    @JoinColumn(name = "clinica_id")
    private Clinica clinica;
}
