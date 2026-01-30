package patronbuilder;

public class Main {
    public static void main(String[] args) {
        // Builder concreto
        BuilderConcretoCasa builder = new BuilderConcretoCasa();

        // Director (Opcional)
        BuilderDirector director = new BuilderDirector(builder);


        // Creando los objetos
        // casa de material, 2 pisos , con garaje  (sin piscina con jardin)
        director.contruirCasaDosPisosMaterial();
        Casa casa1 = builder.obtenerResultado();
        System.out.println("casa 1" + casa1.toString());

        // Casa de material, 1 pisos , con garaje (sin Piscina)
        director.contruirCasaunPisoMaterial();
        Casa casa2 = builder.obtenerResultado();
        System.out.println("casa 2" + casa2.toString());


        // Casa de material, casa de madera , con garaje (sin Piscina)

        director.contruirCasaMaderaMaterial();
        Casa casa3 = builder.obtenerResultado();
        System.out.println("casa 3" + casa3.toString());
    }
}