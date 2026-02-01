package prototype;

import java.util.ArrayList;
import java.util.List;

public class PedidoPizza implements PrototipoPizza<PedidoPizza> {

    private String tamanio;
    private String tipoMasa;
    private List<String> ingredientes;

    // constuctor normal (crear desde cero )
    public PedidoPizza(String tamanio, String tipoMasa, List<String> ingredientes) {
        this.tamanio = tamanio;
        this.tipoMasa = tipoMasa;
        this.ingredientes = new ArrayList<>(ingredientes); // mutable
    }

    // constructor copia
    public PedidoPizza(PedidoPizza prototipo) {
        this.tamanio = prototipo.tamanio;
        this.tipoMasa = prototipo.tipoMasa;
        this.ingredientes =new ArrayList<>(prototipo.ingredientes);
    }

    @Override
    public PedidoPizza clonar() {
        return new PedidoPizza(this);
    }

    // es un metodo para agregar los ingredientes

    public void agregarIngredientes(String ingredientes) {
        this.ingredientes.add(ingredientes);

    }

    @Override
    public String toString() {
        return "PedidoPizza{" +
                "tamanio='" + tamanio + '\'' +
                ", tipoMasa='" + tipoMasa + '\'' +
                ", ingredientes=" + ingredientes +
                '}';
    }
}
