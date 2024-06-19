package rekos_2021.februar.aufgabe_10;

public class LaengenFilter implements Filterkriterium{

    @Override
    public boolean laesstDurch(String wort) {
        return wort.length() > 10;
    }
}
