package rekos_2021.juli.aufgabe_1;

public abstract class Zeichenobjekt2D {
    // (1) Das Keyword "abstract" sorgt dafür, dass kein Objekt der Klasse Zeichenobjekt2D erzeugt werden kann!

    // (3) Jede Unterklasse erbt diese Methode und kann diese auch nicht überschreiben!
    public final String gibInfo(){
        return this.getArt() + "\nBreite: " + this.getBreite() + "\nHöhe: " + this.getHoehe();
    }

    // (2) Das sind Instanzmethoden und keine Variablen!
    protected abstract int getHoehe();

    protected abstract int getBreite();

    protected abstract String getArt();

}
