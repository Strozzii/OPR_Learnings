package rekos_2022.september.aufgabe_1;

public class Rechteck extends Zeichenobjekt {

    private int hoehe;
    private int breite;

    public Rechteck(int hoehe, int breite) {
        this.hoehe = hoehe;
        this.breite = breite;
    }

    @Override
    public double gibFlaeche() {
        return hoehe * breite;
    }

    @Override
    public double gibUmfang() {
        return 2 * hoehe + 2 * breite;
    }

    public static void main(String[] args) {
        Rechteck r = new Rechteck(5, 6);
        System.out.println(r.gibText());
    }
}
