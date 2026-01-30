package org.patronfactory;

public class EnvioCamion implements Envio {
    @Override
    public void enviarPaquete() {
        System.out.println("enviando paquete mediante camion");
    }
}
