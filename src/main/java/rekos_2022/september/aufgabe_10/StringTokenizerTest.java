package rekos_2022.september.aufgabe_10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTokenizerTest {

    private StringTokenizer st;
    private String zeichenkette;
    private String trennzeichen;

    @BeforeEach
    void setUp() {
        zeichenkette = "E-Bike";
    }

    @Test
    void testNextToken() {
        st = new StringTokenizer(zeichenkette, "-");
        st.nextToken();
        st.nextToken();
        assertThrows(NoSuchElementException.class, st::nextToken);
    }

}
