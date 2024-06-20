package rekos_2023.september.aufgabe_2;

public class Rechteck extends Zeichenobjekt{

    private int hoehe;
    private int breite;

    public Rechteck(int hoehe, int breite) {
        this.hoehe = hoehe;
        this.breite = breite;
    }

    @Override
    public String gibTyp() {
        return "Rechteck";
    }

    @Override
    public double gibFlaeche() {
        return this.breite * this.hoehe;
    }
}
