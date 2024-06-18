package rekos_2021.juli.aufgabe_3;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class Geldbetrag {

    private String waehrung;
    private double betrag;

    public Geldbetrag(String waehrung, double betrag){
        this.waehrung = waehrung;
        this.betrag = betrag;
    }

    public static Map<String, Double> summiere(Collection<Geldbetrag> betraege){
        // TreeMap ordnet die Schlüssel der Map alphabetisch
        Map<String, Double> liste = new TreeMap<>();

        // Iteriere durch alle Geldbetrags-Objekte in der Collection
        for(Geldbetrag g : betraege)
        {
            // Falls es zu der aktuellen Währung schon einen Eintrag gibt, dann addiere den Wert dazu
            if(liste.containsKey(g.waehrung))
            {
                liste.put(g.waehrung, liste.get(g.waehrung) + g.betrag);
            }
            // Falls nicht, dann erstelle einen neuen Eintrag
            else
            {
                liste.put(g.waehrung, g.betrag);
            }
        }

        return liste;
    }

}
