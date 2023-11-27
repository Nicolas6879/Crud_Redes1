package com.prueba.controller;

import com.prueba.model.estudiante;
import com.prueba.service.EstudianteService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {
    /*@GetMapping("")
    public String show(Model model){
        model.addAttribute("estudiante",estudianteService.findAll());
        return "estudiantes/show";
    }*/
    @GetMapping("/mostrar")
    public ResponseEntity<List<estudiante>> findAll() {
        return new ResponseEntity<>(this.estudianteService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/buscarPorCodigo/{codigo}")
    public ResponseEntity<estudiante> buscarPorCodigo(@PathVariable Integer codigo) {
        Optional<estudiante> estudiante = estudianteService.getByCodigo(codigo);
        return estudiante.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/buscarPorNombre/{nombre}")
    public ResponseEntity<List<estudiante>> buscarPorNombre(@PathVariable String nombre) {
        List<estudiante> estudiante = estudianteService.getByNombre(nombre);
        if (!estudiante.isEmpty()) {
            return new ResponseEntity<>(estudiante, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private final Logger LOGGER = LoggerFactory.getLogger(EstudianteController.class);
    @Autowired
    private EstudianteService estudianteService;

    @PostMapping("/save")
    public String save(estudiante estudiante){
        LOGGER.info("Este es el objeto estudiante {}",estudiante);
        estudianteService.save(estudiante);
        return "redirect:/estudiante";
    }
    @GetMapping("/edit/{codigo}")
    public String edit(@PathVariable Integer codigo, Model model){
        estudiante estudiante= new estudiante();
        Optional<estudiante> optionalEstudiante = estudianteService.get(codigo);
        estudiante=optionalEstudiante.get();

        LOGGER.info("Estudiante encontrado: {}",estudiante);
        model.addAttribute("estudiante", estudiante);

        return "editarEstudiante";
    }
    @PostMapping("/update/{codigo}")
    public String update(@PathVariable Integer codigo,estudiante estudiante){
        Optional<estudiante> optionalEstudiante = estudianteService.get(codigo);

        if (optionalEstudiante.isPresent()) {
            estudiante existingEstudiante = optionalEstudiante.get();

            if (estudiante.getNombre() != null) {
                existingEstudiante.setNombre(estudiante.getNombre());
            }
            if (estudiante.getApellido() != null) {
                existingEstudiante.setApellido(estudiante.getApellido());
            }
            if (estudiante.getCorreo() != null) {
                existingEstudiante.setCorreo(estudiante.getCorreo());
            }
            if (estudiante.getCarrera() != null) {
                existingEstudiante.setCarrera(estudiante.getCarrera());
            }
            if (estudiante.getCiudad() != null) {
                existingEstudiante.setCiudad(estudiante.getCiudad());
            }

            estudianteService.update(existingEstudiante);

            return "Estudiante editado exitosamente";
        } else {
            return "Estudiante no encontrado";
        }
    }


}
