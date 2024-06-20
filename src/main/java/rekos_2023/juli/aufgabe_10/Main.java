package rekos_2023.juli.aufgabe_10;

import java.io.*;
import java.util.Set;

public class Main {

    public static long kopiere(InputStream is, OutputStream os, long n) throws IOException {
        int anzahl_kopierter_byte = 0;
        int gelesene_bytes;

        byte[] puffer = new byte[1028];


        while (n > 0 && (gelesene_bytes = is.read(puffer, 0, (int) Math.min(puffer.length, n))) != -1) {
            os.write(puffer, 0, gelesene_bytes);
            anzahl_kopierter_byte += gelesene_bytes;
            n -= gelesene_bytes;
        }


        return anzahl_kopierter_byte;
    }

    public static void main(String[] args) throws IOException {
        byte[] inputDaten = new byte[]{100, 101, 102, 106, 103, 104};

        InputStream input = new ByteArrayInputStream(inputDaten);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        System.out.println(kopiere(input, output, 1));
        // Hier kommen ASCII-Zeichen raus (siehe ASCII Tabelle)
        System.out.println(output);


    }
}
