package rekos_2023.juli.aufgabe_2;

public class Schokolade extends Lebensmittel{

    private Zutat[] zutaten;

    public Schokolade() {
        zutaten = new Zutat[]{
                new Zutat("Milch", false),
                new Zutat("Kakao", true)};
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
