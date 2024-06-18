package rekos_2021.juli.aufgabe_5;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class Main {

    public static boolean sindGleich(Reader r1, Reader r2, short n) throws IOException {
        // Anfangszustand der Ausgabe
        boolean gleich = true;

        // Buffer für beide Reader
        char param1[] = new char[n];
        char param2[] = new char[n];

        // Lesen der Zeichen in beiden Readern. Rückgabewert ist die Anzahl der Zeichen.
        int counter1 = r1.read(param1);
        int counter2 = r2.read(param2);

        // Für den Fall, dass eine Zeichenkette kürzer ist als n
        int zaehler = Math.min(Math.min(counter1,counter2), n);

        // Solange "gleich" true ist und der Index sich innerhalb der Buffer befinden, vergleiche das Zeichen an i-ter
        // Stelle. Breche ab, wenn "gleich" false ist.
        for(int i = 0; i < zaehler && gleich; i++){
            gleich = param1[i] == param2[i];
        }
        return gleich;

    }

    public static void main(String[] args) throws IOException {
        Reader r1 = new StringReader("12345678");
        Reader r2 = new StringReader("123456789");
        Reader r3 = new StringReader("123423842");

        // Hier könnt ihr nicht mehrere Printlns hintereinander ausführen, weil die StringReader nach einmaligem
        // lesen nicht mehr auf die ersten Zeichen zugreifen können.
        // Einfach hier mit den Argumenten rumexperimentieren.
        System.out.println(sindGleich(r1, r2, (short) 8));

    }
}
