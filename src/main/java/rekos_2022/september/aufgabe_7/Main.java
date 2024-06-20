package rekos_2022.september.aufgabe_7;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static boolean hatMindestlaenge(InputStream is, long mindestLaenge) throws IOException {
        long counter = mindestLaenge;

        byte[] bytes = new byte[1028];
        int read = is.read(bytes);

        while (read != -1 && counter > 0) {
            counter -= read;

            read = is.read(bytes);
        }

        return counter <= 0;

    }

    public static void main(String[] args) throws IOException {
        byte[] a = new byte[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        InputStream is = new ByteArrayInputStream(a);

        System.out.println(hatMindestlaenge(is, 8));
    }

}
