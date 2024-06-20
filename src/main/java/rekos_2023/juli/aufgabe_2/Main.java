package rekos_2023.juli.aufgabe_2;

public class Main {

    public static void main(String[] args) {
        Kokosnuss k = new Kokosnuss();
        System.out.println("---KOKOSNUSS---");
        System.out.println(k.zutatenText());
        System.out.println(k.istVegan());
        System.out.println("---------------");
        Schokolade s = new Schokolade();
        System.out.println("--- SCHOKII ---");
        System.out.println(s.zutatenText());
        System.out.println(s.istVegan());
        System.out.println("---------------");
        Fleisch f = new Fleisch();
        System.out.println("--- FLEISCH ---");
        System.out.println(f.zutatenText());
        System.out.println(f.istVegan());
        System.out.println("---------------");

    }

}

