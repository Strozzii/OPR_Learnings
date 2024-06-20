package rekos_2023.september.aufgabe_4;

import java.util.HashMap;
import java.util.Map;

public class Katalogartikel {

    private String artikelnummer;
    private String bezeichnung;

    public Katalogartikel(String artikelnummer, String bezeichnung) {
        this.artikelnummer = artikelnummer;
        this.bezeichnung = bezeichnung;
    }

    @Override
    public int hashCode() {
        return artikelnummer.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        boolean isEqual = false;

        if (o instanceof Katalogartikel k) {
            isEqual = this.artikelnummer.equals(k.artikelnummer);
        }

        return isEqual;
    }

    public static void main(String[] args) {
        Katalogartikel k1 = new Katalogartikel("12345678", "Kuscheltier");
        Katalogartikel k2 = new Katalogartikel("12312312", "Buch");
        Katalogartikel k3 = new Katalogartikel("12345678", "Kuscheltier");
        Katalogartikel k4 = new Katalogartikel("11111111", "Fahrrad");

        HashMap<Katalogartikel, String> hm = new HashMap<>();
        hm.put(k1, "Plüschtier zum Kuscheln.");
        hm.put(k2, "So ein Teil zum Lesen.");
        hm.put(k3, "Plüschtier zum Kuscheln.");
        hm.put(k4, "Umweltschonend zur Hochschule fahren.");

        System.out.println(hm.size());

    }
}
