package org.patronabstract;

public class TiendaRopa {

    private OufitFactory factory;
    public TiendaRopa(OufitFactory factory){
        this.factory= factory;

    }

    public void mostrarOutfit(){

        Jean jean = factory.crearJean();
        Ramera ramera= factory.crearRamera();

        jean.descripcion();
        ramera.descripcion();;
    }

}
