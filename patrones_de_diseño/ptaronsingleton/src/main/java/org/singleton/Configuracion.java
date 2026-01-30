package org.singleton;

public class Configuracion {

    private static Configuracion instancia;


    private Configuracion() {

        System.out.println("Inicializzando configuracion en el sistema");

    }
// un metodo publico que sea estatico

    public static Configuracion getInstancia() {
        if (instancia == null) {

            instancia = new Configuracion();
        }
        return instancia;

    }
// 3 partes de un singlenton
    // una clase con contructor privado
    // una variable estatica
    // un metodo publico  que sea estatico

    public void mostrarMensaje() {

        System.out.println("confiugracion activa");
    }

}
