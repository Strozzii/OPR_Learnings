package rekos_2021.februar.aufgabe_8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class StringTest {

    @Test
    void test() {
        try {
            char c = "Haus".charAt(4);
        }
        catch (StringIndexOutOfBoundsException e) {
            // Wird aber fehlschlagen, weil in einer neueren Version von Java der Text anders ist :/
            assertEquals("String index out of range: 4", e.getMessage());
        }
    }

}
