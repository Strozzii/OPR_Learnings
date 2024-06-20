package rekos_2023.juli.aufgabe_2;

public abstract class Lebensmittel {

    public final String zutatenText() {
        String ausgabe = this.anzahlZutaten() > 1 ? "Zutaten: " : "Zutat: ";
        int i;

        for (i = 0; i < this.anzahlZutaten() - 1; i++) {
            ausgabe += gibZutaten()[i].gibName() + ", ";
        }

        ausgabe += gibZutaten()[i].gibName();

        return ausgabe;
    }

    public final boolean istVegan() {
        boolean istVegan = true;

        for(int i = 0; i < this.anzahlZutaten() && istVegan; i++){
            istVegan = this.gibZutaten()[i].istVegan();
        }
        return istVegan;
    }

    public abstract int anzahlZutaten();

    public abstract Zutat[] gibZutaten();

}
