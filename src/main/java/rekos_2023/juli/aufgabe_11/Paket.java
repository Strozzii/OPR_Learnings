package rekos_2023.juli.aufgabe_11;

import java.util.Arrays;
import java.util.Optional;

public enum Paket {

    S(2),
    M(5),
    L(10),
    XL(25);

    private int gewicht_grenze;

    Paket(int gewicht_grenze) {
        this.gewicht_grenze = gewicht_grenze;
    }

    public int maxGewicht() {
        return this.gewicht_grenze;
    }

    public Optional<Paket> paket(double gewicht) {
        return Arrays.stream(Paket.values())
                .filter(p -> p.maxGewicht() >= gewicht)
                .findFirst();
    }


    public static void main(String[] args) {
        System.out.println(S.paket(18));
        System.out.println(S.paket(28));
    }




}
