package org.patronabstract;

public class OutfitEleganteFactory implements OufitFactory{
    @Override
    public Jean crearJean() {
        return  new JeanRecto();
    }

    @Override
    public Ramera crearRamera() {
        return new RameraAlCuerpo();
    }
}
