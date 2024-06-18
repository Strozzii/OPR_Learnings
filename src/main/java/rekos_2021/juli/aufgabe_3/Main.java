package rekos_2021.juli.aufgabe_3;

import java.util.ArrayList;
import java.util.Collection;

import static rekos_2021.juli.aufgabe_3.Geldbetrag.summiere;

public class Main {

    public static void main(String[] args) {
        Collection<Geldbetrag> test = new ArrayList<>();
        test.add(new Geldbetrag("EUR", 30));
        test.add(new Geldbetrag("EUR", 12));
        test.add(new Geldbetrag("CHF", 30));
        test.add(new Geldbetrag("EUR", 8));
        test.add(new Geldbetrag("CHF", 12));
        test.add(new Geldbetrag("USD", 12));

        System.out.println(summiere(test));
    }
}
