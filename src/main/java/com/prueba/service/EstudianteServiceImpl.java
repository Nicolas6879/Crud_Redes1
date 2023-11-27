package com.prueba.service;

import com.prueba.model.estudiante;
import com.prueba.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;
    @Override
    public estudiante save(estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Optional<estudiante> get(Integer codigo) {
        return estudianteRepository.findById(codigo);
    }

    @Override
    public void update(estudiante estudiante) {
        estudianteRepository.save(estudiante);
    }

    @Override
    public void delete(Integer codigo) {
        estudianteRepository.deleteById(codigo);
    }
}
