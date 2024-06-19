package rekos_2021.juli.aufgabe_8;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // ByteArrayOutputStream ist Unterklasse von OutputStream
        OutputStream os = new ByteArrayOutputStream();

        // Float ist breiter als Long und kann nicht in v gespeichert werden
        // long v = 12.5f;

        // Die Hüllklasse Float kann auch den primitiven Datentypen float speichern
        Float f = 12.5f;

        // substring gibt einen String zurück, was Unterklasse von Object ist (wie jede Klasse lol)
        Object o = "Java".substring(3);

        // Reader ist die Oberklasse und kann nicht in einer Unterklasse gespeichert werden
        // BufferedReader b = new Reader(os);

        // KeySet() gibt ein Set zurück und ist Oberklasse von HashSet
        // HashSet<String> h = new HashMap<String, Integer>().keySet();

        // LinkedList implementiert die Schnittstelle List
        List<String> l = new LinkedList<String>();

        /*
        Die Typen der Parameter und der Rückgabewert des Lambda-Ausdrucks stimmen mit der Signatur der compare-Methode
        des Comparator-Interfaces überein, wodurch der Ausdruck typverträglich ist.
         */
        Comparator<String> c = (s, t) -> s.length() - t.length();

    }
}
