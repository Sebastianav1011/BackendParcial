package com.example.parcial.service;

import com.example.parcial.model.Doctor;
import com.example.parcial.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository repository;

    public DoctorService(DoctorRepository repository) {
        this.repository = repository;
    }

    public List<Doctor> findAll() {
        return repository.findAll();
    }

    public Doctor findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id " + id));
    }

    public Doctor save(Doctor doctor) {
        return repository.save(doctor);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Doctor not found with id " + id);
        }
        repository.deleteById(id);
    }
}
