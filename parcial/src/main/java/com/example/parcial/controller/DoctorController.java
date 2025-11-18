package com.example.parcial.controller;

import com.example.parcial.dto.DoctorDto;
import com.example.parcial.model.Clinica;
import com.example.parcial.model.Doctor;
import com.example.parcial.service.ClinicaService;
import com.example.parcial.service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/doctores")
public class DoctorController {

    private final DoctorService service;
    private final ClinicaService clinicaService;
    private final ModelMapper mapper;

    public DoctorController(DoctorService service, ClinicaService clinicaService, ModelMapper mapper) {
        this.service = service;
        this.clinicaService = clinicaService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<DoctorDto> getAll() {
        return service.findAll()
                .stream()
                .map(d -> {
                    DoctorDto dto = mapper.map(d, DoctorDto.class);
                    dto.setClinicaId(d.getClinica() != null ? d.getClinica().getId() : null);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DoctorDto getById(@PathVariable Long id) {
        Doctor doctor = service.findById(id);
        DoctorDto dto = mapper.map(doctor, DoctorDto.class);
        dto.setClinicaId(doctor.getClinica() != null ? doctor.getClinica().getId() : null);
        return dto;
    }

    @PostMapping
    public DoctorDto create(@RequestBody DoctorDto dto) {
        Clinica clinica = clinicaService.findById(dto.getClinicaId());
        Doctor doctor = mapper.map(dto, Doctor.class);
        doctor.setClinica(clinica);
        Doctor saved = service.save(doctor);
        DoctorDto result = mapper.map(saved, DoctorDto.class);
        result.setClinicaId(clinica.getId());
        return result;
    }

    @PutMapping("/{id}")
    public DoctorDto update(@PathVariable Long id, @RequestBody DoctorDto dto) {
        Clinica clinica = clinicaService.findById(dto.getClinicaId());
        Doctor doctor = mapper.map(dto, Doctor.class);
        doctor.setId(id);
        doctor.setClinica(clinica);
        Doctor updated = service.save(doctor);
        DoctorDto result = mapper.map(updated, DoctorDto.class);
        result.setClinicaId(clinica.getId());
        return result;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
