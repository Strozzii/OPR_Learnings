package rekos_2023.september.aufgabe_1;

public class F extends E {

    /*

    Die Signatur ist gleich bis auf den Rückgabetyp.
    Dadurch weiss Java nicht, welche von beiden m-Methoden beim Aufruf gemeint ist.

    public String m(int n) {
        return "Quadrat: " + n * n;
    }
    */

    // Man kann entweder den Namen der Methode ändern oder den Rückgabetyp auf int ändern, aber dann kann man keinen
    // Text mehr zurückgeben :(
    public String m2(int n) {
        return "Quadrat: " + n * n;
    }
}
