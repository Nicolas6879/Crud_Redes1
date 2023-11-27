package com.prueba.repository;

import com.prueba.model.estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<estudiante, Integer> {
    Optional<estudiante> findByCodigo(Integer codigo);
    List<estudiante> findByNombre(String nombre);
}
