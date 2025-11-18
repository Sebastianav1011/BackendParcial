package com.example.parcial.service;

import com.example.parcial.model.Clinica;
import com.example.parcial.repository.ClinicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicaService {

    private final ClinicaRepository repository;

    public ClinicaService(ClinicaRepository repository) {
        this.repository = repository;
    }

    public List<Clinica> findAll() {
        return repository.findAll();
    }

    public Clinica findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clinica not found with id " + id));
    }

    public Clinica save(Clinica clinica) {
        return repository.save(clinica);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Clinica not found with id " + id);
        }
        repository.deleteById(id);
    }
}
