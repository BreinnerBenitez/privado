package org.singleton;

public class Main {
    public static void main(String[] args) {


        // modulo del sistema

        System.out.println("Modulo de Autenticacion");
        Configuracion config1 = Configuracion.getInstancia();
        config1.mostrarMensaje();
        // 2 modulo de reporte
        System.out.println("Modulo de reportes ");
        Configuracion config2 = Configuracion.getInstancia();
        config2.mostrarMensaje();

        //comprobacion

        System.out.println("¿ambas referencia en memoria son iguales?");
        System.out.println(config1 == config2);


    }
}