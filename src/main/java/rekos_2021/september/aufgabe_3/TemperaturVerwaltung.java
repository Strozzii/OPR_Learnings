package rekos_2021.september.aufgabe_3;

import java.util.HashSet;


public class TemperaturVerwaltung {
    private final HashSet<Temperatur> temperatures;

    public TemperaturVerwaltung(){
        temperatures = new HashSet<>();
    }

    public int fuegeHinzu(Temperatur t){

        temperatures.add(t);

        return temperatures.size();
    }

    /**
     * Für Aufgabe nicht wichtig!
     */
    @Override
    public String toString(){
        return "" + temperatures;
    }




}
