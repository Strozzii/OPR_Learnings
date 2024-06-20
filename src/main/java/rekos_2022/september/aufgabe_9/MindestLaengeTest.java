package rekos_2022.september.aufgabe_9;

import org.junit.jupiter.api.Test;
import rekos_2022.september.aufgabe_7.Main;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MindestLaengeTest {

    @Test
    void testMindestLaenge() throws IOException {
        byte[] a = new byte[] {1,2,3,4,5,6,7};
        InputStream is = new ByteArrayInputStream(a);

        assertTrue(Main.hatMindestlaenge(is, 6));
    }
}
