package rekos_2021.februar.aufgabe_10;

import java.util.ArrayList;
import java.util.List;

public class Listenfilter {

    public static List<String> filter(List<String> elemente, char anfang) {
        ArrayList<String> gefilterteElemente = new ArrayList<>();

        for (String element : elemente) {

            if (!element.isEmpty() && element.charAt(0) == anfang) {
                gefilterteElemente.add(element);
            }

        }

        return gefilterteElemente;
    }

    // Die neue Filtermethode
    public static List<String> filter(List<String> elemente, Filterkriterium filter) {
        return elemente.stream()
                .filter(wort -> filter.laesstDurch(wort))
                .toList();
    }


}
