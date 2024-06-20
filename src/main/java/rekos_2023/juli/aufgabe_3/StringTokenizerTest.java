package rekos_2023.juli.aufgabe_3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTokenizerTest {

    private StringTokenizer st;
    private String zeichenkette;

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
