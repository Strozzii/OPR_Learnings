# Lösung
***

## Grundgerüst
````java
public static boolean enthaelt(InputStream is, Set<Byte> bytes) throws IOException {
    boolean enthaelt_bytes = false;

    return enthaelt_bytes;
}
````
* Damit fange ich immer zuerst an 🙂

***

## Plan

Hier können wir uns den Hinweis zu nutzen machen:

`Es ist zulässig, die übergebene Menge zu verändern, z. B. indem Sie daraus im Laufe der
Verarbeitung byte-Werte entfernen`

Eine Idee wäre es, jedes Zeichen aus dem ``InputStream`` zu lesen und dieses aus dem `Set` zu löschen, falls dieser
vorhanden ist.

Das machen wir so lange, bis das ``Set`` leer ist, oder wir das Ende des Streams erreicht haben.
* Im ersten Fall bekommen wir ``true``
* Im zweiten Fall ``false``

***

## Implementierung

````java
public static boolean enthaelt(InputStream is, Set<Byte> bytes) throws IOException {
    boolean enthaelt_bytes = false;
    byte gelesenes_byte;

    while (!enthaelt_bytes && (gelesenes_byte = (byte) is.read()) != -1) {
        bytes.remove(gelesenes_byte);
        enthaelt_bytes = bytes.isEmpty();
    }

    return enthaelt_bytes;
}
````

### Schrittweise Erklärung
````java
byte gelesenes_byte;
````
* Hier speichern wir das aktuelle Byte des ``InputStreams``

````java
while (!enthaelt_bytes && (gelesenes_byte = (byte) is.read()) != -1)
````
* Es müssen zwei Bedingungen erfüllt sein (verUNDung), um den ``InputStream`` auszulesen
  * Die Negation von ``enthaelt_bytes`` bedeutet, dass wir noch keine Bestätigung haben, dass alle Bytes enthalten sind
  * Das gelesene Byte muss vorhanden sein, bzw wir dürfen nicht am Ende angekommen sein

Die zweite Bedingung beinhaltet zusätzlich eine Zuweisung, um in der Schleife das nächste gelesene Byte zu speichern
* Der Typecast in Byte ist nötig da ``is.read()`` ein Integer zurückgibt und dieser "breiter" ist als Byte

````java
bytes.remove(gelesenes_byte);
enthaelt_bytes = bytes.isEmpty();
````
* Die erste Zeile entfernt aus dem Set das Byte, wenn es vorhanden ist
  * Ein Check, ob es enthalten ist, müssen wir nicht machen dank der Collection
* Der Boolean erhält jedesmal eine neue Zuweisung, ob das Set leer ist

Wenn das Set leer ist, bedeutet das, dass alle Bytes enthalten sind und die Schleife stoppt.

[Hier kannst du es mal ausprobieren](Main.java)
