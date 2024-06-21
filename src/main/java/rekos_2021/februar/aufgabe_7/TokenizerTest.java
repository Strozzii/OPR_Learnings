package rekos_2021.februar.aufgabe_7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class TokenizerTest {

    private Reader r;

    @BeforeEach
    void setUp() {
        r = new StringReader("Viel Erfolg bei OPR.");
    }

    @Test
    void testGibWoerter1() throws IOException {
        ReaderTokenizer rt = new ReaderTokenizer(r, ". ");
        HashSet<String> ist = (HashSet<String>) rt.gibWoerter();
        HashSet<String> soll = new HashSet<>();

        soll.add("Viel");
        soll.add("bei");
        soll.add("Erfolg");
        soll.add("OPR");

        assertEquals(soll, ist);
    }

    @Test
    void testGibWoerter2() throws IOException {
        ReaderTokenizer rt = new ReaderTokenizer(r, ".,!");
        HashSet<String> ist = (HashSet<String>) rt.gibWoerter();
        HashSet<String> soll = new HashSet<>();

        soll.add("Viel Erfolg bei OPR");

        assertEquals(soll, ist);
    }
}



