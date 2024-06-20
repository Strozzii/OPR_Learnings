package rekos_2023.september.aufgabe_8;

public class Konto {
    private float kontostand;
    private boolean istPrivat;

    public Konto(float kontostand, boolean istPrivat){
        this.kontostand = kontostand;
        this.istPrivat = istPrivat;
    }

    public boolean istPrivatKonto() {
        return this.istPrivat;
    }

    public float kontostand() {
        return this.kontostand;
    }

}
