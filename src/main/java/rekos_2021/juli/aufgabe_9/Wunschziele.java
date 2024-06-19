package rekos_2021.juli.aufgabe_9;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Wunschziele implements Protokollierer {

    private String startflughafen;
    private Set<String> wunschziele;

    public Wunschziele(String startflughafen) {
        this.startflughafen = startflughafen;
        this.wunschziele = new HashSet<>();
    }

    @Override
    public void protokolliereSuche(String start, String ziel, List<Flug> ergebnisse) {
        if (start.equals(this.startflughafen) && ergebnisse.isEmpty()) {
            wunschziele.add(ziel);
        }
    }

    public Set<String> gibWunschziele() {
        return wunschziele;
    }
}

