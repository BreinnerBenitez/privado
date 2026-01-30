package org.patronfactory;

public class EnvioCorreo implements Envio {


    @Override
    public void enviarPaquete() {
        System.out.println("enviando paquete mediante correo");

    }
}
