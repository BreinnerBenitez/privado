package org.patronabstract;

public class Main {
    public static void main(String[] args) {


        //selecionamos una familia de productos

        OufitFactory factory = new OutfitUrbanoFactory();

        //cliente trabaja o va interactuar sin saber las calses concreas
        TiendaRopa tienda = new TiendaRopa(factory);

        tienda.mostrarOutfit();


    }
}