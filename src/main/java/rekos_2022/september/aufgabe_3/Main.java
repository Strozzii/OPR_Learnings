package rekos_2022.september.aufgabe_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static Map<Integer, Set<String>> ereignisseNachJahren(Map<String, Integer> ereignisse) {
        Map<Integer, Set<String>> ausgabe = new HashMap<>();

        for(Map.Entry<String, Integer> ereignisEintrag : ereignisse.entrySet()) {
            int jahr = ereignisEintrag.getValue();
            String ereignis = ereignisEintrag.getKey();

            if(!ausgabe.containsKey(jahr)) {
                TreeSet<String> ereignisMenge = new TreeSet<>();
                ausgabe.put(jahr, ereignisMenge);
            }

            ausgabe.get(jahr).add(ereignis);
        }

        return ausgabe;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hs = new HashMap<>();
        hs.put("A_Ereignis", 1990);
        hs.put("B_Ereignis", 1992);
        hs.put("C_Ereignis", 1994);
        hs.put("D_Ereignis", 1992);
        hs.put("E_Ereignis", 1993);
        hs.put("F_Ereignis", 1990);
        hs.put("G_Ereignis", 1800);
        hs.put("H_Ereignis", 1992);
        hs.put("I_Ereignis", 1990);

        System.out.println(ereignisseNachJahren(hs));
    }

}
