package rekos_2021.september.aufgabe_6;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static rekos_2021.september.aufgabe_5.Main.minLaengeUndZeichen;

public class MinLaengeUndZeichenTest {

    private Reader r;

    @Before
    public void setUp(){
        r = new StringReader("ababababccc");
    }

    @Test
    public void test1() throws IOException {
        assertFalse(minLaengeUndZeichen(r, (short) 8, (short) 3));
    }

    @Test
    public void test2() throws IOException {
        assertTrue(minLaengeUndZeichen(r, (short) 9, (short) 3));
    }

}
