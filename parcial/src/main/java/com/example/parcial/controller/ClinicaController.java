package com.example.parcial.controller;

import com.example.parcial.dto.ClinicaDto;
import com.example.parcial.model.Clinica;
import com.example.parcial.service.ClinicaService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clinicas")
public class ClinicaController {

    private final ClinicaService service;
    private final ModelMapper mapper;

    public ClinicaController(ClinicaService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<ClinicaDto> getAll() {
        return service.findAll()
                .stream()
                .map(c -> mapper.map(c, ClinicaDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ClinicaDto getById(@PathVariable Long id) {
        Clinica clinica = service.findById(id);
        return mapper.map(clinica, ClinicaDto.class);
    }

    @PostMapping
    public ClinicaDto create(@RequestBody ClinicaDto dto) {
        Clinica clinica = mapper.map(dto, Clinica.class);
        Clinica saved = service.save(clinica);
        return mapper.map(saved, ClinicaDto.class);
    }

    @PutMapping("/{id}")
    public ClinicaDto update(@PathVariable Long id, @RequestBody ClinicaDto dto) {
        Clinica clinica = mapper.map(dto, Clinica.class);
        clinica.setId(id);
        Clinica updated = service.save(clinica);
        return mapper.map(updated, ClinicaDto.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
