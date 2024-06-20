package rekos_2023.juli.aufgabe_7;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        TreeSet<String> woerter = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int compare_value = o2.length() - o1.length();

                if (compare_value == 0) {
                    compare_value = o1.charAt(0) - o2.charAt(0);
                }

                return compare_value;
            }
        });

        woerter.add("Apfel");
        woerter.add("Birne");
        woerter.add("Zitrone");
        woerter.add("birne");
        woerter.add("Nuss");

        System.out.println(woerter);

    }


}
