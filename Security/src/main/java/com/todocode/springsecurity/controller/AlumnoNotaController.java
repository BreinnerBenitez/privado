package com.todocode.springsecurity.controller;

import com.todocode.springsecurity.service.IAlumnoNotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calificacion")
public class AlumnoNotaController {

    @Autowired
    private IAlumnoNotaService alumnonota;


    @GetMapping()
    public List<Integer> devolverClasificacion() {

        return alumnonota.numeros();
    }

    @GetMapping("/average")
    public Integer promedio() {

        return  alumnonota.promedioNumeros();
    }
}
