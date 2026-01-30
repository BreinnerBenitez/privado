package patronbuilder;

public class BuilderDirector {
    private BuilderCasa builder;

    // constructor propio de la clase
    public BuilderDirector(BuilderCasa builder) {
        this.builder = builder;

    }

    // para cambiar de constructor
    public void cambiarBuilder(BuilderCasa builder) {

        this.builder = builder;
    }

    // Casa de material, 2 pisos , con garaje (sin Piscina)
    public void contruirCasaDosPisosMaterial() {
        builder.reiniciar();
        builder.contruirEstructura("material");
        builder.construirPisos(2);
        builder.construirPiscina(false);
        builder.construirGarage(true);
        builder.construirJardin(true);
        builder.agregarExtra("balcon");
    }

    // Casa de material, 1 pisos , con garaje (sin Piscina)
    public void contruirCasaunPisoMaterial() {
        builder.reiniciar();
        builder.contruirEstructura("material");
        builder.construirPisos(1);
        builder.construirPiscina(false);
        builder.construirGarage(true);
        builder.construirJardin(true);
        builder.agregarExtra("alredor de la piscina");


    }


    // Casa de material, casa de madera , con garaje (sin Piscina)
    public void contruirCasaMaderaMaterial() {
        builder.reiniciar();
        builder.contruirEstructura("material");
        builder.construirPisos(1);
        builder.construirPiscina(false);
        builder.construirGarage(false);
        builder.construirJardin(true);

    }

}
