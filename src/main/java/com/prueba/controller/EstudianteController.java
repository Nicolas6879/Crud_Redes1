package com.prueba.controller;

import com.prueba.model.estudiante;
import com.prueba.service.EstudianteService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {
    //public String create(){
      //  return
    //}
    private final Logger LOGGER = LoggerFactory.getLogger(EstudianteController.class);
    @Autowired
    private EstudianteService estudianteService;

    @PostMapping("/save")
    public String save(estudiante estudiante){
        LOGGER.info("Este es el objeto estudiante {}",estudiante);
        estudianteService.save(estudiante);
        return "redirect:/estudiante";
    }


}
