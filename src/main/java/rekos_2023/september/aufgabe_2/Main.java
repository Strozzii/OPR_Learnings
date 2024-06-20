package rekos_2023.september.aufgabe_2;

public class Main {

    public static void main(String[] args) {

        Rechteck r = new Rechteck(4, 5);
        Kreis k = new Kreis(3);

        System.out.println(r.info());
        System.out.println(k.info());

        System.out.println(r.istGroesser(k));


    }

}
