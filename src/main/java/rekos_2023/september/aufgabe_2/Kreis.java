package rekos_2023.september.aufgabe_2;

public class Kreis extends Zeichenobjekt {

    private int radius;

    public Kreis(int radius) {
        this.radius = radius;
    }


    @Override
    public String gibTyp() {
        return "Kreis";
    }

    @Override
    public double gibFlaeche() {
        return this.radius * this.radius * Math.PI;
    }
}
