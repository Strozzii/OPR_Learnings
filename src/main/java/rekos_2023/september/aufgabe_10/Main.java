package rekos_2023.september.aufgabe_10;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;

public class Main {

    public static long kopiere(InputStream input, OutputStream output, Set<Integer> erlaubteWerte) throws IOException {
        byte[] buffer = new byte[1];
        long anzahlBytes = 0;
        int geleseneBytes;
        boolean kopiereWeiter = true;

        while (kopiereWeiter && (geleseneBytes = input.read(buffer)) != -1) {
            int gueltigeBytes = 0;

            for (int i = 0; i < geleseneBytes; i++) {
                kopiereWeiter = erlaubteWerte.contains((int) buffer[i]);
                if (!kopiereWeiter) {
                    break;
                }
                gueltigeBytes++;
            }

            output.write(buffer, 0, gueltigeBytes);
            anzahlBytes += gueltigeBytes;

        }

        return anzahlBytes;
    }

    public static void main(String[] args) throws IOException {
        Set<Integer> erlaubteWerte = Set.of(100, 101, 102, 103, 104, 105);

        byte[] inputDaten = new byte[]{100, 101, 102, 106, 103, 104};

        InputStream input = new ByteArrayInputStream(inputDaten);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        System.out.println(kopiere(input, output, erlaubteWerte));
        // Hier kommen ASCII-Zeichen raus (siehe ASCII Tabelle)
        System.out.println(output);


    }

}
