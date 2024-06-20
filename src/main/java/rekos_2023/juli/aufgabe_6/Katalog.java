package rekos_2023.juli.aufgabe_6;

import java.util.ArrayList;
import java.util.List;

public class Katalog {

    // Aus Testzwecken mocke ich diese Methode
    public List<Katalogartikel> suche(String suchbegriff){
        ArrayList<Katalogartikel> ergebnis = new ArrayList<>();

        if (suchbegriff.equals("Ball")){
            Katalogartikel k = new Katalogartikel("Ball");
            ergebnis.add(k);
        }

        return ergebnis;

    }

}
