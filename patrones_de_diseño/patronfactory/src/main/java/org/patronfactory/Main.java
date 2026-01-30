package org.patronfactory;

public class Main {
    public static void main(String[] args) {

        EnvioCreator envioCorreo = new EnvioCorreoCreator();
        envioCorreo.procesarEnvio();

        EnvioCreator envioCamion = new EnvioCamionCreator();
        envioCamion.procesarEnvio();

        EnvioCreator envioMoto = new EnvioMotoCreator();
        envioMoto.procesarEnvio();
    }
}

