package rekos_2021.februar.aufgabe_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ReaderTokenizer {

    private Reader reader;
    private String trennzeichen;

    /**
     * Erzeugt ein Objekt dieser Klasse für den übergebenen Reader und
     * die übergebenen Trennzeichen.
     * @param r Reader, dessen Zeichenstrom in Wörter zerlegt wird.
     * Es wird vorausgesetzt, dass der Zeichenstrom endlich ist.
     * @param trennzeichen Jedes Zeichen dieser Zeichenkette ist ein
     * Trenner (analog zu Trennzeichen bei StringTokenizer).
     */
    public ReaderTokenizer(Reader r, String trennzeichen) {
        this.reader = r;
        this.trennzeichen = trennzeichen;
    }

    /**
     * Liefert die Wörter des Zeichenstroms.
     * @return Set<String> die Menge der Wörter im Zeichenstrom.
     */
    public Set<String> gibWoerter() throws IOException {
        Set<String> woerter = new HashSet<>();
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(line, trennzeichen);
            while (tokenizer.hasMoreTokens()) {
                woerter.add(tokenizer.nextToken());
            }
        }

        return woerter;
    }
}


