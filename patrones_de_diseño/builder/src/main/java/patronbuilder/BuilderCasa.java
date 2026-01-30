package patronbuilder;
// builder general
public interface BuilderCasa {

    void reiniciar();
    void contruirEstructura(String estructura);
    void construirPisos (int cnatidad);
    void construirPiscina (boolean siOno);
    void construirGarage (boolean siOno);
    void construirJardin (boolean siOno);
    void agregarExtra (String extra);

}
