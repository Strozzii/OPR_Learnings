package rekos_2023.september.aufgabe_1;

public class B extends A{

    // @Override    <-- Fehler, wegen private Methode in Elternklasse
    public int m(float f) {
        return 2 * (int) f;
    }

}
