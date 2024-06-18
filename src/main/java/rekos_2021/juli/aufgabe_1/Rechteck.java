package rekos_2021.juli.aufgabe_1;

public class Rechteck extends Zeichenobjekt2D {

    private String art;
    private int breite;
    private int hoehe;

    public Rechteck(int breite, int hoehe){
        this.art = "Rechteck";
        this.breite = breite;
        this.hoehe = hoehe;
    }

    @Override
    protected int getHoehe() {
        return this.hoehe;
    }

    @Override
    protected int getBreite() {
        return this.breite;
    }

    @Override
    protected String getArt() {
        return this.art;
    }
}
