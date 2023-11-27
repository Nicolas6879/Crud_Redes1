package com.prueba.repository;

import com.prueba.model.estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<estudiante, Integer> {

}
