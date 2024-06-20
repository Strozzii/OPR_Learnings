package rekos_2022.september.aufgabe_8;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.IntPredicate;

public class FilteredInputStream {

    private final InputStream is;
    private final IntPredicate filter;

    public FilteredInputStream(InputStream is, IntPredicate filter) {
        this.is = is;
        this.filter = filter;
    }

    /**
     * Liefert nächsten Bytewert des Eingabestroms für den das Filterkriterium erfüllt ist.
     * Wenn Kriterium nicht erfüllt oder kein Wert, dann ist die Ausgabe -1.
     */

    public int read() throws IOException {
        int byteRead;

        while ((byteRead = is.read()) != -1) {

            if (filter.test(byteRead)) {
                return byteRead;
            }

        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        // Test mit geraden Zahlen
        testFilteredStream(new byte[]{1, 2, 3, 4, 5, 6}, value -> value % 2 == 0);

        // Test mit ungeraden Zahlen
        testFilteredStream(new byte[]{1, 3, 5, 7}, value -> value % 2 == 0);
    }

    private static void testFilteredStream(byte[] data, IntPredicate filter) throws IOException {
        InputStream is = new ByteArrayInputStream(data);
        FilteredInputStream fis = new FilteredInputStream(is, filter);

        int value;
        boolean found = false;
        while ((value = fis.read()) != -1) {
            found = true;
            System.out.println(value);
        }
        if (!found) {
            System.out.println("-1");
        }
    }

}
