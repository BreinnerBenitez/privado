package patronbuilder;

import java.util.ArrayList;
import java.util.List;

public class BuilderConcretoCasa implements BuilderCasa {

    private Casa resultado;
    private List<String> extras = new ArrayList<>();

    @Override
    public void reiniciar() {
        this.resultado = new Casa();
        this.extras = new ArrayList<>();
    }

    @Override
    public void contruirEstructura(String tipoEstructura) {
        resultado.setTipoEstructura(tipoEstructura);
    }


    @Override
    public void construirPisos(int cantidad) {
        resultado.setPisos(cantidad);
    }

    @Override
    public void construirPiscina(boolean siOno) {
        resultado.setPiscina(siOno);
    }

    @Override
    public void construirGarage(boolean siOno) {
        resultado.setGarage(siOno);
    }

    @Override
    public void construirJardin(boolean siOno) {
        resultado.setJardin(siOno);
    }

    @Override
    public void agregarExtra(String extra) {

        extras.add(extra);
        resultado.setExtras(extras);
    }
    // metodo tipico de un Builder concreto
    public Casa obtenerResultado(){

        return resultado;
    };

}
