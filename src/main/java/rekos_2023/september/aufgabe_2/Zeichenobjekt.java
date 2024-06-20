package rekos_2023.september.aufgabe_2;

public abstract class Zeichenobjekt {

    public final String info() {
        return "" + this.gibTyp() + ", Fläche = " + this.gibFlaeche();
    }

    public final boolean istGroesser(Zeichenobjekt z) {
        return this.gibFlaeche() > z.gibFlaeche();
    }

    public abstract String gibTyp();

    public abstract double gibFlaeche();



}
