package org.patronabstract;

public class OutfitUrbanoFactory implements OufitFactory {
    @Override
    public Jean crearJean() {
        return new JeanCargo();
    }

    @Override
    public Ramera crearRamera() {
        return new RameraOversize();
    }
}
