package com.example.parcial.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "clinicas")
@Getter
@Setter
public class Clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identificador") // opcional, solo si quieres que la columna en BD se llame así
    private Long id;

    private String nombre;

    private String direccion;

    @Column(name = "cantidad_camas")
    private Integer cantidadCamas;

    private String telefono;

    private String ciudad;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @OneToMany(mappedBy = "clinica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Doctor> doctores;
}
