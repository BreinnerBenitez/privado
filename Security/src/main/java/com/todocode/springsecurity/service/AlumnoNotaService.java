package com.todocode.springsecurity.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnoNotaService implements IAlumnoNotaService {
    List <Integer> listaNotas = new ArrayList <> ();
    int suma =0;
    @Override
    public ArrayList<Integer> numeros() {
        listaNotas.clear();
        for (int i = 0; i < 8; i++) {
            listaNotas.add(i);
        }

        return (ArrayList<Integer>) listaNotas;
    }

    @Override
    public Integer promedioNumeros() {

        for (int numero: listaNotas) {

            suma += numero;
        }

        int promedio = 0;
        if (!listaNotas.isEmpty()) {
            promedio = suma / listaNotas.size();
        }

        return promedio;
    }
}
