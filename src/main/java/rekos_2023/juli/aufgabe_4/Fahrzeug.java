package rekos_2023.juli.aufgabe_4;

public class Fahrzeug {

    private String kennzeichen;

    public Fahrzeug(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    @Override
    public int hashCode(){
        return kennzeichen.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        boolean isEqual = false;

        if (o instanceof Fahrzeug f) {
            isEqual = this.kennzeichen.equals(f.kennzeichen);
        }

        return isEqual;
    }

}
