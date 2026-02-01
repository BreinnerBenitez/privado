package prototype;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        // 1 ) crear un protitpo base  ("plantilla" de la nuestra piazza)

        PedidoPizza prototipoMuzza = new PedidoPizza(
                "grande",
                "normal",
                List.of("muzarella", "salsa de tomate")

        );

        // 2) varieante clon con aceitunas

        PedidoPizza muzzaAceitunas = prototipoMuzza.clonar();
        muzzaAceitunas.agregarIngredientes("aceitunas");

        //3  vatientes con jamo

        PedidoPizza muzzaJamon = prototipoMuzza.clonar();
        muzzaJamon.agregarIngredientes("jamon");

        // cariante especal

        PedidoPizzaEspecial prorotipoEspecial =new PedidoPizzaEspecial(
                "mediana",
                "fina",
                List.of("muzarella","salsa"),
                true

        );

        PedidoPizzaEspecial especialConRucula = prorotipoEspecial.clonar();
        especialConRucula.agregarIngredientes("recula");
        // Resultados

        System.out.println("protipo Base: "+prototipoMuzza+"/n");
        System.out.println("variante con aceitunas"+ muzzaAceitunas);
        System.out.println("bariante con Jamon"+ muzzaJamon);
        System.out.println("protitpo especial "+prorotipoEspecial);
        System.out.println(" con rucukula"+especialConRucula);

    }
}