package rekos_2022.september.aufgabe_4;

import java.util.HashSet;

public class Rechteck {

    private int breite;
    private int laenge;

    public Rechteck(int breite, int laenge) {

        if(breite < 0 || laenge < 0) {
            throw new IllegalArgumentException("Breite oder Laenge dürfen nicht negativ sein!");
        }

        this.breite = breite;
        this.laenge = laenge;
    }

    @Override
    public int hashCode() {
        return breite * laenge;
    }

    @Override
    public boolean equals(Object o) {
        boolean isEqual = false;

        if(o instanceof Rechteck r) {
            isEqual = this.breite * this.laenge == r.breite * r.laenge;
        }

        return isEqual;
    }

    @Override
    public String toString() {
        return "Fläche: " + (this.breite * this.laenge);
    }

    public static void main(String[] args) {
        Rechteck r1 = new Rechteck(1, 2);
        Rechteck r2 = new Rechteck(2, 1);
        Rechteck r3 = new Rechteck(4, 6);
        Rechteck r4 = new Rechteck(5, 10);
        Rechteck r5 = new Rechteck(1, 50);

        HashSet<Rechteck> hs = new HashSet<>();
        hs.add(r1);
        hs.add(r2);
        hs.add(r3);
        hs.add(r4);
        hs.add(r5);

        System.out.println(hs.size());

        // Ab Zeile 44 mit der Reihenfolge des Hinzufügens rumspielen
        // Reihenfolge folgt keiner der genannten Regeln
        for(Rechteck r : hs) {
            System.out.println(r);
        }

        Rechteck rError = new Rechteck(-1, 0);
    }

}
