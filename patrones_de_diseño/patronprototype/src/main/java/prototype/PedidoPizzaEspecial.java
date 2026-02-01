package prototype;

import java.util.List;

public class PedidoPizzaEspecial extends PedidoPizza {
    private boolean bordeRelleno;

    public PedidoPizzaEspecial(String tamanio, String tipoMasam, List<String> ingredientes, boolean bordeRelleno) {
        super(tamanio, tipoMasam, ingredientes);
        this.bordeRelleno = bordeRelleno;
    }

    public PedidoPizzaEspecial(PedidoPizza prototipo) {
        super(prototipo);
        this.bordeRelleno = bordeRelleno;
    }

    @Override
    public PedidoPizzaEspecial clonar(){
        return new PedidoPizzaEspecial(this);

    }

    @Override
    public String toString() {
        return "PedidoPizzaEspecial{" +
                "bordeRelleno=" + bordeRelleno +
                ", "+super.toString()+
                '}';
    }
}
