package rekos_2021.juli.aufgabe_4;

public class Geldbetrag {

    private String waehrung;
    private double betrag;

    public Geldbetrag(String waehrung, double betrag){

        // (1) Die Überprüfung findet beim Erzeugen eines neuen Geldbetrag-Objektes statt!
        if(waehrung.length() != 3){
            throw new IllegalArgumentException(waehrung + " ist kein zulässiges Währungskürzel!");
        }

        this.waehrung = waehrung;
        this.betrag = betrag;
    }

    // (2) equals und hashcode sind wichtige Bestandteile, damit Objekte dieser Klasse als Hash-Schlüssel verwendet
    // werden können!

    @Override
    public boolean equals(Object g){
        boolean equal = false;
        if(g instanceof Geldbetrag){
            // Überprüfung: Gleicher Betrag und gleiche Währung
            equal = this.waehrung.equals(((Geldbetrag) g).waehrung) && this.betrag == ((Geldbetrag) g).betrag;
        }
        return equal;
    }

    @Override
    public int hashCode(){
        return this.waehrung.hashCode() + (int)(this.betrag * 100);
    }

    // Nicht beachten! Das ist nur zum printen von Geldbeträgen. Für die Klausur nicht wichtig.
    @Override
    public String toString(){
        return this.waehrung + " und " + this.betrag;
    }


}
