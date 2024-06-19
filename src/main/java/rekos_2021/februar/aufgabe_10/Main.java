package rekos_2021.februar.aufgabe_10;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> liste = new LinkedList<>();
        liste.add("1234512345");
        liste.add("12345123");
        liste.add("1234512345123");
        liste.add("");

        List<String> gefiltert = Listenfilter.filter(liste, new LaengenFilter());
        // List<String> gefiltert = Listenfilter.filter(liste, wort -> wort.length() > 10);

        System.out.println(gefiltert);




    }

}
