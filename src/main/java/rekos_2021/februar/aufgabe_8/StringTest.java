package rekos_2021.februar.aufgabe_8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class StringTest {

    @Test
    void test() {
        try {
            char c = "Haus".charAt(4);
            fail();
        }
        catch (StringIndexOutOfBoundsException e) {
            assertEquals("String index out of range: 4", e.getMessage());
        }
    }

}
