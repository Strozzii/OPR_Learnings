package rekos_2021.juli.aufgabe_9;

import java.util.ArrayList;
import java.util.List;

public class Mock_DB {

    /**
     *  Diese Methode hilft mir nur die Datenbanksuche zu simulieren, sodass ich Testdaten habe um das Ganze
     *  ausprobieren zu können. Nicht klausurrelevant.
     */
    public static List<Flug> mock_db_suche(String start, String ziel) {
        List<Flug> ergebnis = new ArrayList<>();
        if (ziel.equals("München") || ziel.equals("Frankfurt")) {
            ergebnis.add(new Flug());
            ergebnis.add(new Flug());
        }
        return ergebnis;
    }
}
