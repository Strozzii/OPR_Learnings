package rekos_2021.juli.aufgabe_4;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // Geldbetrag gError = new Geldbetrag("AB", 3); // Hier wird eine Exception geworfen wegen AB
        Geldbetrag g1 = new Geldbetrag("EUR", 20);
        Geldbetrag g2 = new Geldbetrag("USD", 20);
        Geldbetrag g3 = new Geldbetrag("USD", 10);
        Geldbetrag g4 = new Geldbetrag("EUR", 20);
        Geldbetrag g5 = new Geldbetrag("LIR", 40);

        Map<Geldbetrag, String> hm = new HashMap<>();

        hm.put(g1, "1");
        hm.put(g2, "2");
        hm.put(g3, "3");
        hm.put(g4, "4");
        hm.put(g5, "5");

        // This Map enthält nur 4 statt 5 Geldbeträge, weil g1 und g4 gleich sind (dank equals und hashcode)
        System.out.println(hm);
    }


}
