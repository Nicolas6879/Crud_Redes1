package com.prueba.service;

import com.prueba.model.estudiante;

import java.util.Optional;

public interface EstudianteService {
    public estudiante save(estudiante estudiante);
    public Optional<estudiante> get(Integer codigo);
    public void update(estudiante estudiante);
    public void delete (Integer codigo);
}
