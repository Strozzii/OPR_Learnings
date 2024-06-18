package rekos_2021.september.aufgabe_7;

import java.io.Reader;

public class Messwerteleser {

    private Reader r;
    private Messwertverarbeiter m;

    public Messwerteleser(Reader r, Messwertverarbeiter m){
        this.r = r;
        this.m = m;
    }

    public boolean gibtEsWeiterenMesswert() {
        return true;
    }

    public Messwert gibNaechstenMesswert(){
        return new Messwert("Herne", 39);
    }

     public void lies(){
        while(this.gibtEsWeiterenMesswert()){
            Messwert wert = this.gibNaechstenMesswert();
            this.m.verarbeite(wert);
            break;


        }
     }

}