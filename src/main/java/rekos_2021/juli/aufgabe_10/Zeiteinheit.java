package rekos_2021.juli.aufgabe_10;

public enum Zeiteinheit {

    SEKUNDE(1),
    MINUTE(60),
    STUNDE(60 * 60),
    TAG(60 * 60 * 24);
    private int s;

    Zeiteinheit(int s){
        this.s = s;
    }

    int sekunde(){
        return s;
    }

    double in(Zeiteinheit z){
        return (double) this.sekunde() / z.sekunde();
    }

    public static void main(String[] args) {
        System.out.println(STUNDE.sekunde());
        System.out.println(STUNDE.in(MINUTE));
        System.out.println(MINUTE.in(STUNDE));
    }

}
