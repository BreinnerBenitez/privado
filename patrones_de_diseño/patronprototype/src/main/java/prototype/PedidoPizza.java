package prototype;

import java.util.List;

public class PedidoPizza implements PrototipoPizza<PedidoPizza> {

    private String tamanio;
    private String tipoMasa;
    private List<String> ingredientes;

    // constuctor normal (crear desde cero )
    public PedidoPizza(String tamanio, String tipoMasam, List<String> ingredientes) {
        this.tamanio = tamanio;
        this.tipoMasa = tipoMasa;
        this.ingredientes = ingredientes;
    }

    // constructor copia
    public PedidoPizza(PedidoPizza prototipo) {
        this.tamanio = prototipo.tamanio;
        this.tipoMasa = prototipo.tipoMasa;
        this.ingredientes = prototipo.ingredientes;
    }

    @Override
    public PedidoPizza clonar() {
        return new PedidoPizza(this);
    }

    // es un metodo para agregar los ingredientes

    public void agregarIngredientes(String ingrefientes) {
        this.ingredientes.add(ingrefientes);

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
