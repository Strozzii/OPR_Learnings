package rekos_2023.september.aufgabe_3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TreeSetTest {

    private TreeSet<String> ts;

    @BeforeEach
    void setUp() {
        ts = new TreeSet<>();
    }

    @Test
    void testException() {
        ts.add("A");
        ts.add("B");

        Iterator<String> iter = ts.iterator();
        iter.next();
        iter.next();

        assertThrows(NoSuchElementException.class, iter::next);

    }

}
