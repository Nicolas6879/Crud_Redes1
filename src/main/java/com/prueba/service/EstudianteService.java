package com.prueba.service;

import com.prueba.model.estudiante;

import java.util.List;
import java.util.Optional;

public interface EstudianteService {
    public estudiante crear(estudiante estudiante);
    public Optional<estudiante> get(Integer codigo);
    public void update(estudiante estudiante);
    public void delete (Integer codigo);
    public List<estudiante> findAll();
    public Optional<estudiante> getByCodigo(Integer codigo);
    public List<estudiante> getByNombre(String nombre);


}
