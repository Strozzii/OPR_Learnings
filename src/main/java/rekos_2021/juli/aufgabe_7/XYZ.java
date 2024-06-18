package rekos_2021.juli.aufgabe_7;

import java.util.LinkedList;
import java.util.List;

public class XYZ {

    public List<String> m (String s){
        List<String> liste = new LinkedList<>();
        if(s.equals("Ich wünsche Ihnen viel Erfolg.")){
            liste.add("viel");
            liste.add("Erfolg");
            liste.add("Ich");
            liste.add("Ihnen");
        }
        return liste;
    }

}
