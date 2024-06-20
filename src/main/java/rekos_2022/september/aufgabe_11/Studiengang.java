package rekos_2022.september.aufgabe_11;

public enum Studiengang {

    IN_BA(6),
    WI_BA(6),
    WI_DUAL(8),
    MI_MA(4);


    private int semester;

    Studiengang(int semester){
        this.semester = semester;
    }

    public boolean istBachelorstudiengang() {
        return this.regelstudienzeit() == 6;
    }

    public int regelstudienzeit() {
        return semester;
    }

    public static void main(String[] args) {
        System.out.println(IN_BA.istBachelorstudiengang());
        System.out.println(WI_BA.istBachelorstudiengang());
        System.out.println(WI_DUAL.istBachelorstudiengang());
        System.out.println(MI_MA.istBachelorstudiengang());

    }

}
