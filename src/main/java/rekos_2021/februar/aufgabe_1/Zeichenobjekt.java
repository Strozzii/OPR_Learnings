package rekos_2021.februar.aufgabe_1;

public abstract class Zeichenobjekt {

    public final boolean istGroesser(Zeichenobjekt zeichenobjekt){
        return this.getGroesse() > zeichenobjekt.getGroesse();
    }

    public abstract double getGroesse();
}
