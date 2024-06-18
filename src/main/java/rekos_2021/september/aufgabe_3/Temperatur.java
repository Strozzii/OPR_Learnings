package rekos_2021.september.aufgabe_3;

public class Temperatur{

    private final float t;

    public Temperatur(float t){
        if(t < -273.15f){
            throw new IllegalArgumentException("Es existieren keine Temperaturen unterhalb des Nullpunkts");
        }
        this.t = t;
    }

    public float wert(){
        return t;
    }

    @Override
    public int hashCode(){
        return (int)(t * 10000);
    }

    @Override
    public boolean equals(Object o){
        boolean isEquals = false;
        if(o instanceof Temperatur){
            isEquals = ((Temperatur)o).wert() == this.wert();
        }
        return isEquals;
    }

    /**
     * Für Aufgabe nicht wichtig!
     */
    @Override
    public String toString(){
        return "" + wert();
    }
}
