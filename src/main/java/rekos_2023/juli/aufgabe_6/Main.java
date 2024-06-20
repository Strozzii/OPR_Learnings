package rekos_2023.juli.aufgabe_6;

public class Main {

    public static void main(String[] args) {

        KeineTreffer kt = new KeineTreffer();
        Onlineshop shop = new Onlineshop(kt);

        /**
         * Jetzt folgen viele Suchvorgänge.
         * Die werden aus Testzwecken gemocked.
         *
         * Nur zu "Ball" gibt es Treffer.
         */

        shop.suche("Auto");
        shop.suche("Ball");
        shop.suche("Auto");
        shop.suche("ChooChoo");

        System.out.println("Zu diesen Suchbegriffen wurde nichts gefunden: " + kt.gibSuchBegriffe());

    }

}
