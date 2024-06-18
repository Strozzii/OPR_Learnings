package rekos_2021.september.aufgabe_3;

public class Main {
    public static void main(String[] args) {

        TemperaturVerwaltung tv = new TemperaturVerwaltung();

        Temperatur t_error = new Temperatur(-300);

        Temperatur t1 = new Temperatur(32.3f);
        Temperatur t2 = new Temperatur(12.4f);
        Temperatur t3 = new Temperatur(35);
        Temperatur t4 = new Temperatur(32.3f);

        System.out.println(tv.fuegeHinzu(t1));
        System.out.println(tv.fuegeHinzu(t2));
        System.out.println(tv.fuegeHinzu(t3));
        System.out.println(tv.fuegeHinzu(t4));

        System.out.println(tv);





    }
}
