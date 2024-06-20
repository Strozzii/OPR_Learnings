package rekos_2023.juli.aufgabe_6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeineTreffer implements Suchprotokollierer {

    private HashSet<String> suchbegriffe;

    public KeineTreffer() {
        this.suchbegriffe = new HashSet<>();
    }

    public Set<String> gibSuchBegriffe() {
        return this.suchbegriffe;
    }

    @Override
    public void protokolliere(String suchbegriff, List<Katalogartikel> treffer) {

        if (treffer.isEmpty()) {
            this.suchbegriffe.add(suchbegriff);
        }

    }
}
