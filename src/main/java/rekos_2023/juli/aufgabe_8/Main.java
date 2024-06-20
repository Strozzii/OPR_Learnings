package rekos_2023.juli.aufgabe_8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.stream.LongStream;

public class Main {

    public static boolean istPrimzahl(long number) {
        boolean istPrim;

        istPrim = number >= 2;

        for (int i = 2; i <= Math.sqrt(number) && istPrim; i++) {

            istPrim = number % i != 0;

        }

        return istPrim;
    }

    public static void main(String[] args) throws FileNotFoundException {

        /**
         * Teilaufgabe 1
         */

        Konto k1 = new Konto(12.3f, true);
        Konto k2 = new Konto(12.3f, true);
        Konto k3 = new Konto(12.3f, false);
        Konto k4 = new Konto(12.3f, true);
        Konto k5 = new Konto(12.3f, false);

        HashSet<Konto> hs = new HashSet<>();
        hs.add(k1);
        hs.add(k2);
        hs.add(k3);
        hs.add(k4);
        hs.add(k5);

        double summe = hs.stream()
                .filter(Konto::istPrivatKonto)
                .mapToDouble(Konto::kontostand)
                .sum();

        System.out.println((float)summe);

        /**
         * Teilaufgabe 2
         */

        // Limit, damit wir keinen Überlauf haben
        LongStream stream = LongStream.iterate(1, i -> i + i + 1).limit(25).filter(x -> istPrimzahl(x));

        stream.forEach(System.out::println);

        /**
         * Teilaufgabe 3
         */

        BufferedReader r_true = new BufferedReader(
                new FileReader("src/main/java/rekos_2023/september/aufgabe_8/true.txt")
        );
        BufferedReader r_false = new BufferedReader(
                new FileReader("src/main/java/rekos_2023/september/aufgabe_8/false.txt")
        );

        int n = 9;
        boolean ergebnis = r_true.lines()
                .allMatch(s -> s.length() >= n);

        System.out.println(ergebnis);

        ergebnis = r_false.lines()
                .allMatch(s -> s.length() >= n);

        System.out.println(ergebnis);

    }

}
