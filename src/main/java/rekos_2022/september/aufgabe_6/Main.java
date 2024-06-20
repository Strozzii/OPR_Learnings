package rekos_2022.september.aufgabe_6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        /**
         * Teilaufgabe 1
         */

        BufferedReader br_true = new BufferedReader(
                new FileReader("src/main/java/rekos_2022/september/aufgabe_6/true.txt")
        );
        BufferedReader br_false = new BufferedReader(
                new FileReader("src/main/java/rekos_2022/september/aufgabe_6/false.txt")
        );

        boolean ergebnis;

        ergebnis = br_true.lines()
                .anyMatch(s -> {StringTokenizer st = new StringTokenizer(s, " "); return st.countTokens() >= 5;});

        System.out.println(ergebnis);

        ergebnis = br_false.lines()
                .anyMatch(s -> {StringTokenizer st = new StringTokenizer(s, " "); return st.countTokens() >= 5;});

        System.out.println(ergebnis);


        /**
         * Teilaufgabe 2
         */

        List<Buch> buecher = new ArrayList<>();

        Buch b1 = new Buch(99, "10 Schritte bis zum Erfolg");
        Buch b2 = new Buch(10, "Wie man reich wird!");
        Buch b3 = new Buch(8, "Alle reisen nach Jerusalem");
        Buch b4 = new Buch(1, "Programmieren für Vollidioten");
        Buch b5 = new Buch(69, "Kamasutra");
        Buch b6 = new Buch(420, "Grünen-Politik");

        buecher.add(b1);
        buecher.add(b2);
        buecher.add(b3);
        buecher.add(b4);
        buecher.add(b5);
        buecher.add(b6);

        Buch buch_unter_10 = buecher.stream()
                .filter(buch -> buch.gibPreisInEuro() < 10)
                .findFirst()
                .orElse(null);

        System.out.println("Das erste Buch, was unter 10€ kostet: " + buch_unter_10);


        /**
         * Teilaufgabe 3
         */

        int summe = buecher.stream()
                .filter(buch -> buch.gibPreisInEuro() > 10)
                .mapToInt(Buch::gibPreisInEuro)
                .sum();

        System.out.println("Preissumme von Büchern über 10€: " + summe);








    }
}
