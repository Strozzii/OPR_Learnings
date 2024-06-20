package rekos_2023.september.aufgabe_6;

import java.util.List;

public class Flugportal {

    private Protokollierer protokollierer;

    public Flugportal(Protokollierer protokollierer) {
        this.protokollierer = protokollierer;
    }

    /**
     * Liefert alle Direktflüge vom Start- zum Zielflughafen.
     */
    public List<Flug> sucheDirektfluege(String start, String ziel) {

        List<Flug> verbindungen = Mock_DB.mock_db_suche(start, ziel); // in Datenbestand suchen


        // Protokollierung der Suchanfrage und Ergebnisse
        protokollierer.protokolliereSuche(start, ziel, verbindungen);
        return verbindungen;
    }


    public static void main(String[] args) {

        Wunschziele wunschzieleMuenster = new Wunschziele("Münster");

        Flugportal portal = new Flugportal(wunschzieleMuenster);

        /*
         * Hier denken wir uns viele Suchvorgänge im Flugportal.
         *
         * Nachtrag: Argumente sind für Testzwecke.
         */
        portal.sucheDirektfluege("Münster", "Berlin");
        portal.sucheDirektfluege("Münster", "München");
        portal.sucheDirektfluege("Münster", "Hamburg");
        portal.sucheDirektfluege("Münster", "Frankfurt");

        System.out.println("Wunschziele ab Münster: " + wunschzieleMuenster.gibWunschziele());

    }
}

