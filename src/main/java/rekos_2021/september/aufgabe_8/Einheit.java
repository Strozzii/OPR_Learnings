package rekos_2021.september.aufgabe_8;

public enum Einheit {
    MUM(1000),
    MM(10),
    CM(10),
    DM(10),
    M(1000),
    KM(1);

    private final int faktor;


    Einheit(int factorToNext) {
        this.faktor = factorToNext;
    }

    public Einheit geeigneteEinheit(long aktuelle_zahl) {
        Einheit[] einheiten = Einheit.values();
        int index = this.ordinal();

        while (index < einheiten.length - 1) {
            long naechste_zahl = aktuelle_zahl / einheiten[index].faktor;
            if (naechste_zahl < 1) {
                break;
            }
            aktuelle_zahl = naechste_zahl;
            index++;
        }

        return einheiten[index];
    }

    public static void main(String[] args) {

        System.out.println(CM.geeigneteEinheit(12000));
        System.out.println(MM.geeigneteEinheit(2_000_000));

    }
}


