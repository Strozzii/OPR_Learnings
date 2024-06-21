package rekos_2021.februar.aufgabe_3;

import java.util.*;

public class Main {

    public static Map<Character, Collection<String>> erzeugeIndex(String[] woerter){
        Map<Character, Collection<String>> ausgabe = new HashMap<>();

        for (String s : woerter) {
            char erstes_zeichen = s.charAt(0);

            if (ausgabe.containsKey(erstes_zeichen)) {
                ausgabe.get(erstes_zeichen).add(s);
            }
            else {
                HashSet<String> liste = new HashSet<>();
                liste.add(s);

                ausgabe.put(erstes_zeichen, liste);
            }

        }

        return ausgabe;
    }

    public static void main(String[] args) {
        String[] woerter = {
                "Fahrrad",
                "123 Abflussreinigung",
                "Fahrstuhl",
                "frische Blumen",
                "Fahrrad",
                "Pfirsich"
        };

        System.out.println(erzeugeIndex(woerter));
    }

}
