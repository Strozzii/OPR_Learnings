package rekos_2021.februar.aufgabe_1;

public class Main {


    public static void main(String[] args) {
        Zeichenobjekt r = new Rechteck(4, 5);
        Zeichenobjekt k = new Kreis(3);

        System.out.println("Größe vom Rechteck: " + r.getGroesse());
        System.out.println("Größe vom Kreis: " + k.getGroesse());
        System.out.println(
                r.istGroesser(k) ? "Das Rechteck ist größer!" : "Der Kreis ist größer!"
        );

    }
}
