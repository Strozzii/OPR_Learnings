package rekos_2021.februar.aufgabe_1;

public class Kreis extends Zeichenobjekt{

    private int radius;

    public Kreis(int radius) {
        this.radius = radius;
    }

    @Override
    public double getGroesse() {
        return Math.PI * radius * radius;
    }
}
