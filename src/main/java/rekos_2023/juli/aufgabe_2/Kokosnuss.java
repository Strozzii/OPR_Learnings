package rekos_2023.juli.aufgabe_2;

public class Kokosnuss extends Lebensmittel{

    private Zutat[] zutaten;

    public Kokosnuss() {
        zutaten = new Zutat[]{
                new Zutat("Kokos", true),
                new Zutat("Nuss", true)};
    }

    @Override
    public int anzahlZutaten() {
        return zutaten.length;
    }

    @Override
    public Zutat[] gibZutaten() {
        return zutaten;
    }
}
