package rekos_2023.september.aufgabe_5;

import java.util.Collection;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Ein Objekt dieser Klasse dient dazu, die Anzahl Exemplare von Vögeln zu zählen.
 */
public class Vogelzaehlung {

    private TreeMap<String, Integer> tm;

    public Vogelzaehlung() {
        tm = new TreeMap<>();
    }

    /**
     * Es wird eine Anzahl Exemplare eines Vogels gezählt. Gibt es bereits einen Zählwert
     * für diesen Vogel, wird dieser Wert um die Anzahl erhöht.
     *
     * @param vogel     Vogel, der gezählt wird.
     * @param anzahl    Anzahl Exemplare des Vogels; es wird davon ausgegangen,
     *                  dass die Anzahl größer als 0 ist.
     */
    public void vogel(String vogel, int anzahl) {

        if (tm.containsKey(vogel)) {
            tm.put(vogel, tm.get(vogel) + anzahl);
        }
        else {
            tm.put(vogel, anzahl);
        }
    }

    /**
     * Liefert alle Vögel, die gezählt wurden.
     *
     * @return  Alle Vögel als Collection; bei einer Iteration über die Collection sollen die Vögel in
     *          alphabetischer Reihenfolge durchlaufen werden.
     */
    public Collection<String> alleVoegel() {

        return new TreeSet<>(tm.keySet());
    }

    /**
     * Liefert den Zählwert für einen Vogel.
     *
     * @param vogel Vogel, für den der Zählwert geliefert wird.
     * @return      Zählwert für den Vogel oder 0, wenn Vogel bisher nicht gezählt wurde.
     */
    public int anzahl(String vogel) {

        Integer anzahl = tm.get(vogel);

        return anzahl == null ? 0 : anzahl;

    }

}
