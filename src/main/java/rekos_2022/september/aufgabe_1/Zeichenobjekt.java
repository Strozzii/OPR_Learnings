package rekos_2022.september.aufgabe_1;

public abstract class Zeichenobjekt {

    public final String gibText() {
        return "F=" + this.gibFlaeche() + ", U=" + this.gibUmfang();
    }

    public abstract double gibFlaeche();

    public abstract double gibUmfang();

}
