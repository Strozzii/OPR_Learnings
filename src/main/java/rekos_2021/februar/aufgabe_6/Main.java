package rekos_2021.februar.aufgabe_6;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static boolean enthaelt(InputStream is, Set<Byte> bytes) throws IOException {
        boolean enthaelt_bytes = false;
        byte gelesenes_byte = 0;

        while (!enthaelt_bytes && gelesenes_byte != -1){
            gelesenes_byte = (byte) is.read();

            bytes.remove(gelesenes_byte);

            enthaelt_bytes = bytes.isEmpty();

        }

        return enthaelt_bytes;
    }

    public static void main(String[] args) throws IOException {
        byte[] a = new byte[] {1,2,5,5,1,2,5,5,1,2,1,5,1,2,5,5,1,2,5,5,1,2,5,5};
        InputStream is = new ByteArrayInputStream(a);
        Set<Byte> set = new HashSet<>();
        set.add((byte) 1);
        set.add((byte) 2);
        set.add((byte) 8);

        System.out.println(enthaelt(is, set));

        byte[] b = new byte[] {1,2,5,5,1,2,5,5,1,2,1,8,1,2,5,5,1,2,5,5,1,2,5,5};
        InputStream is2 = new ByteArrayInputStream(b);
        Set<Byte> set2 = new HashSet<>();
        set.add((byte) 1);
        set.add((byte) 2);
        set.add((byte) 8);

        System.out.println(enthaelt(is2, set2));
    }

}
