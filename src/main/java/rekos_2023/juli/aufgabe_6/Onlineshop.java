package rekos_2023.juli.aufgabe_6;

import java.util.List;

public class Onlineshop {

    private Katalog katalog;
    private Suchprotokollierer sp;

    public Onlineshop(Suchprotokollierer sp) {

        this.sp = sp;
        katalog = new Katalog();

    }

    /**
     *Sucht im katalog nach Artikeln, die zu dem Suchbegriff passen.
     */
    public List<Katalogartikel> suche(String suchbegriff) {
        List<Katalogartikel> treffer = katalog.suche(suchbegriff);

        this.sp.protokolliere(suchbegriff, treffer);

        return treffer;
    }

}
