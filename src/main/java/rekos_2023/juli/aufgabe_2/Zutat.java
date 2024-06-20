package rekos_2023.juli.aufgabe_2;

public class Zutat {

    private String name;
    private boolean istVegan;

    public Zutat(String name, boolean istVegan) {
        this.name = name;
        this.istVegan = istVegan;
    }

    public String gibName(){
        return this.name;
    }

    public boolean istVegan() {
        return this.istVegan;
    }

}
