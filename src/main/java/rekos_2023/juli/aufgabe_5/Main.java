package rekos_2023.juli.aufgabe_5;

public class Main {

    public static void main(String[] args) {
        Vogelzaehlung v = new Vogelzaehlung();

        v.vogel("B_Vogel", 3);
        v.vogel("E_Vogel", 2);
        v.vogel("A_Vogel", 1);
        v.vogel("E_Vogel", 5);
        v.vogel("C_Vogel", 8);

        System.out.println(v.alleVoegel());
        System.out.println(v.anzahl("E_Vogel"));
        System.out.println(v.anzahl("Kein_Vogel"));



    }

}
