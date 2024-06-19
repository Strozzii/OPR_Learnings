package rekos_2021.februar.aufgabe_4;

import java.util.HashSet;

public class Zeitdauer {

    private int stunden;
    private int minuten;

    public Zeitdauer(int stunden, int minuten) {

        if (stunden < 0 || minuten < 0){
            throw new IllegalArgumentException("Stunde und Minute müssen größer gleich 0 sein!");
        }

        this.stunden = stunden;
        this.minuten = minuten;

    }

    @Override
    public int hashCode(){
        return stunden * 60 + minuten;
    }

    @Override
    public boolean equals(Object o) {
        boolean isEqual = false;

        if (o instanceof Zeitdauer z){
            isEqual = (this.stunden * 60 + this.minuten) == (z.stunden * 60 + z.minuten);
        }

        return isEqual;
    }

    public static void main(String[] args) {
        Zeitdauer z1 = new Zeitdauer(1, 100);
        Zeitdauer z2 = new Zeitdauer(2, 40);

        HashSet<Zeitdauer> hs = new HashSet<>();
        hs.add(z1);
        hs.add(z2);

        System.out.println(hs); // In der Ausgabe ist nur ein Element vorhanden, was richtig ist!

        Zeitdauer zError = new Zeitdauer(-2, 5);    // Exception sollte geworfen werden!
    }

}
