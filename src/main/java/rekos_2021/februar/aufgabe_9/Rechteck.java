package rekos_2021.februar.aufgabe_9;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Rechteck implements Comparable<Rechteck> {

    private int breite;
    private int hoehe;

    public Rechteck(int breite, int hoehe) {
        this.breite = breite;
        this.hoehe = hoehe;
    }

    @Override
    public int hashCode() {
        return hoehe * hoehe * breite * breite;
    }

    @Override
    public boolean equals(Object o) {
        boolean isEqual = false;

        if (o instanceof Rechteck r) {
            isEqual = (this.breite == r.breite) && (this.hoehe == r.hoehe);
        }

        return isEqual;
    }

    @Override
    public int compareTo(Rechteck r) {
        int vergleichswert;

        vergleichswert = r.hoehe - this.hoehe;

        if (vergleichswert == 0){
            vergleichswert = this.breite - r.breite;
        }

        return vergleichswert;
    }

    @Override
    public String toString() {
        return "(" + breite + " x " + hoehe + ")";
    }

    public static void main(String[] args) {
        Rechteck r1 = new Rechteck(2, 6);
        Rechteck r2 = new Rechteck(1, 8);
        Rechteck r3 = new Rechteck(3, 8);
        Rechteck r4 = new Rechteck(6, 5);
        Rechteck r5 = new Rechteck(4, 5);

        List<Rechteck> rechtecke = new LinkedList<>();
        rechtecke.add(r1);
        rechtecke.add(r2);
        rechtecke.add(r3);
        rechtecke.add(r4);
        rechtecke.add(r5);

        // Unsortiert
        System.out.println("Unsortiere Liste: " + rechtecke);

        Collections.sort(rechtecke);

        // Sortiert
        System.out.println("Sortiere Liste: " + rechtecke);

        TreeSet<Rechteck> ts = new TreeSet<>();
        ts.add(r1);
        ts.add(r2);
        ts.add(r3);
        ts.add(r4);
        ts.add(r5);

        System.out.println("TreeSet ohne Dopplung: " + ts);

        ts.add(new Rechteck(6, 5));

        System.out.println("TreeSet mit Dopplung: " + ts);


    }

}
