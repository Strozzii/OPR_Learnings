package rekos_2021.september.aufgabe_9;

public class OnlineBanking {

    private static PINregel regel;

    public void setzePINregel(PINregel regel){
        OnlineBanking.regel = regel;
    }


    public static void main(String[] args) {
        OnlineBanking ob = new OnlineBanking();
        ob.setzePINregel(pin -> pin.length() >= 5 && pin.charAt(0) != pin.charAt(pin.length() - 1));

        System.out.println(regel.istZulaessig("ababaaanab"));

        ob.setzePINregel(pin -> false);

        System.out.println(regel.istZulaessig("ababaaanab"));

    }

}
