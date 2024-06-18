package rekos_2021.juli.aufgabe_6;

import org.junit.Before;
import org.junit.Test;
import rekos_2021.juli.aufgabe_5.Main;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SindGleichTest {

    private Reader r1;
    private Reader r2;

    @Before
    public void setUp() {

        r1 = new StringReader("1234567890");
        r2 = new StringReader("123456783234245");

    }

    @Test
    public void testfall1() throws IOException {
        char[] buffer1 = new char[1000];
        char[] buffer2 = new char[1000];

        int laenge1 = r1.read(buffer1);
        int laenge2 = r2.read(buffer2);

        assertTrue((laenge1 >= 10) && (laenge2 >= 10));
    }

    @Test
    public void testfall2() throws IOException {

        assertTrue(Main.sindGleich(r1, r2, (short) 8));

    }

    @Test
    public void testfall3() throws IOException {

        assertFalse(Main.sindGleich(r1, r2, (short) 9));

    }

}
