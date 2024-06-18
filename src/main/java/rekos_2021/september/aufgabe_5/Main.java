package rekos_2021.september.aufgabe_5;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashSet;

public class Main {

    public static boolean minLaengeUndZeichen(Reader r, short l, short n) throws IOException {
        boolean gueltig;

        HashSet<Character> buchstaben = new HashSet<>();

        char[] buffer = new char[l];
        int reader = r.read(buffer);

        gueltig = reader >= l;

        if(gueltig){

            for(int i = 0; i < l; i++){
                buchstaben.add(buffer[i]);
            }

            gueltig = buchstaben.size() >= n;
        }

        return gueltig;
    }

    public static void main(String[] args) throws IOException {

        Reader r = new StringReader("a5a55ba5ba@bb");
        System.out.println(minLaengeUndZeichen(r, (short) 11, (short) 4));

    }

}
