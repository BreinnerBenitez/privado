package org.patronfactory;

public abstract class EnvioCreator {

    //Factory Method
    protected abstract Envio crearEnvio();

    // logica
 // logica  en comun que van a tener todos tipos d eenvio
    public void procesarEnvio() {

        Envio envio = crearEnvio(); // llamar a nuestro factory method
        envio.enviarPaquete();

    }
}
