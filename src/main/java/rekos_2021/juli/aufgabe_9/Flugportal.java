package rekos_2021.juli.aufgabe_9;

import java.util.ArrayList;
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
        /*
         * Objekt der Klasse Wunschziele erzeugen. Hier etwas ergänzen.
         */
        Wunschziele wunschzieleMuenster = new Wunschziele("Münster");

        /*
         * Flugportal erzeugen. Hier etwas ergänzen.
         */
        Flugportal portal = new Flugportal(wunschzieleMuenster);

        /*
         * Es folgen viele Aufrufe der Methode sucheDirektfluege. Hier nichts ergänzen.
         *
         * Nachtrag: Argumente sind für Testzwecke.
         */
        portal.sucheDirektfluege("Münster", "Berlin");
        portal.sucheDirektfluege("Münster", "München");
        portal.sucheDirektfluege("Münster", "Hamburg");
        portal.sucheDirektfluege("Münster", "Frankfurt");

        /*
         * Wunschziele für Startflughafen Münster ausgeben. Hier etwas ergänzen.
         */
        System.out.println("Wunschziele ab Münster: " + wunschzieleMuenster.gibWunschziele());

    }
}

