package org.patronabstract;

public class OutfitClasicoFactory implements OufitFactory{
    @Override
    public Jean crearJean() {
        return new JeanSkinny();
    }

    @Override
    public Ramera crearRamera() {
        return new RameraAlCuerpo();
    }
}
