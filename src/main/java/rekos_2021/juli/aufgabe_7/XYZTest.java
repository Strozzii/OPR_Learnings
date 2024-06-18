package rekos_2021.juli.aufgabe_7;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class XYZTest {

    private XYZ xyz = new XYZ();

    @Test
    void testM(){
        List<String> soll = new LinkedList<>();
        soll.add("viel");
        soll.add("Erfolg");
        soll.add("Ich");
        soll.add("Ihnen");

        assertEquals(soll, xyz.m("Ich wünsche Ihnen viel Erfolg." ));
        assertNotEquals(soll, xyz.m("BlaBla" ) );
    }

}
