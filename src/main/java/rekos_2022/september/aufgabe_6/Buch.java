package rekos_2022.september.aufgabe_6;

public class Buch {

    private int preis;
    private String titel;

    public Buch(int preis, String titel){
        this.preis = preis;
        this.titel = titel;
    }

    public int gibPreisInEuro() {
        return this.preis;
    }

    @Override
    public String toString() {
        return titel;
    }
}
