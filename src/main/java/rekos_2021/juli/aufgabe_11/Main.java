package rekos_2021.juli.aufgabe_11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader r = new BufferedReader(new FileReader("src/main/java/rekos_2021/juli/aufgabe_11/r1.txt"));
        List<Integer> l = new ArrayList<>();

        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(7);

        System.out.println(r.lines()
                .filter(s -> s.length() > 40)
                .findFirst()
                .get());

        System.out.println(r.lines()
                .allMatch(s -> s.length() >= 10));

        l.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        LongStream.iterate(0, i -> (i + i + 1))
                .limit(50)
                .forEach(System.out::println);
    }


}
