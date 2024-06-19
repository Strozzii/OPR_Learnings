package rekos_2021.februar.aufgabe_1;

public class Rechteck extends Zeichenobjekt{

    private int hoehe;
    private int breite;

    public Rechteck(int hoehe, int breite) {
        this.hoehe = hoehe;
        this.breite = breite;
    }

    @Override
    public double getGroesse() {
        return hoehe * breite;
    }
}
