package rekos_2021.juli.aufgabe_1;

public class Main {

    public static void main(String[] args) {

        //Zeichenobjekt2D z2D = new Zeichenobjekt2D();    // Compile-Error, weil Klasse abstract ist!

        Zeichenobjekt2D rechteck = new Rechteck(100, 25);

        System.out.println(rechteck.gibInfo());


    }
}
