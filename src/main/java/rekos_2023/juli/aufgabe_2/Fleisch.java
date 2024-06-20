package rekos_2023.juli.aufgabe_2;

public class Fleisch extends Lebensmittel{

    private Zutat[] zutaten;

    public Fleisch() {
        zutaten = new Zutat[]{
                new Zutat("Tier", false)
        };
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
