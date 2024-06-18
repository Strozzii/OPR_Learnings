package rekos_2021.september.aufgabe_4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    private TreeMap<String, ArrayList<Integer>> hm = new TreeMap<>();

    public void fuegeHinzu(String schluessel, int zahl){

        ArrayList<Integer> l = hm.get(schluessel);
        if(l != null) {
            l.add(zahl);
            // hm.put(schluessel, l);
        }
    }


    public static void main(String[] args) {
        Main main = new Main();

        ArrayList<Integer> aInt = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            aInt.add(i);
        }
        main.hm.put("Test", aInt);

        main.fuegeHinzu("Test", 69);

        System.out.println(main.hm);
    }
}
