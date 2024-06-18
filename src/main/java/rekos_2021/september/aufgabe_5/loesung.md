# Lösung
***

Um diese Aufgabe zu lösen hab ich mich Schritt für Schritt rangetastet. Dabei fange ich immer mit der Ausgabe der Methode
an:
````java
public static boolean minLaengeUndZeichen(Reader r, short l, short n) {
        boolean gueltig = true;

        return gueltig;
    }
````

### Reader

Da wir hier einen **Reader** verwenden muss aufjedenfall sichergestellt sein, dass wir die Zeichen, die wir lesen, 
irgendwo zwischenspeichern. Um es möglichst effizient zu machen, bietet sich der Einsatz eines Buffers an (also ein
char-Array), um sämtliche gelesene Zeichen abzuspeichern und dann aufeinmal zu verarbeiten.

````java
public static boolean minLaengeUndZeichen(Reader r, short l, short n) throws IOException {
        boolean gueltig;

        char[] buffer = new char[l];
        int reader = r.read(buffer);

        return gueltig;
    }
````
* Das Array ist nur l-Plätze groß, da wir ja nur auf dieser Zeichenlänge überprüfen müssen
* `reader` speichert die Anzahl der gelesenen Bytes (also Zeichen)
  * Wenn also die "Datei" nur 8 Zeichen hat, dann ist `reader = 8`
* Mit `r.read(buffer)` werden maximal soviele Zeichen gelesen, wie das Array groß ist (also l)
  * Die Zeichen werden dann auch in das Array gespeichert
* Das `throws IOException` ist notwendig, da `r.read()` potenziell diese Exception werfen kann


### Mindestlänge überprüfen

Eine Anforderung der Methode ist, dass die Anzahl der übergebenen Zeichen im Reader mindestens l betragen soll. Bei 
einer geringeren Anzahl soll die Methode false zurückgeben.

````java
public static boolean minLaengeUndZeichen(Reader r, short l, short n) throws IOException {
        boolean gueltig;
        

        char[] buffer = new char[l];
        int reader = r.read(buffer);

        gueltig = reader >= l;
        
        return gueltig;
    }
````

* Hier benutze ich `reader` um zu schauen, ob die Anzahl der gelesenen Zeichen die Mindestlänge l erreicht
  * Wenn nicht, dann ist der Ausgabewert `false`

### Anzahl unterschiedlicher Zeichen

Hierbei bietet es sich an jedes Zeichen in einer separaten Datenstruktur zu speichern. Dabei muss nur darauf geachtet
werden, dass kein Zeichen mehrmals gespeichert wird. Am Ende kann man dann einfach die Anzahl der Zeichen zählen und 
das Ergebnis dann mit n vergleichen.

##### Doch wie?

Blickt man zurück auf die Aufgabe mit der LinkedList, dann hatten wir ja da ein ähnliches Szenario. Dort war allerdings
die LinkedList sehr ineffizient. Aber wir wissen ja, dass ein Set von Natur aus schon keine doppelten Werte abspeichert!

Dementsprechend können wir diese Collection ja verwenden:

````java
public static boolean minLaengeUndZeichen(Reader r, short l, short n) throws IOException {
        boolean gueltig;

        HashSet<Character> buchstaben = new HashSet<>();

        char[] buffer = new char[l];
        int reader = r.read(buffer);

        gueltig = reader >= l;

        return gueltig;
    }
````
* Als Typklasse nehmen wir die Hüllklasse `Character`, weil `char` nicht geht
  * Das Verhalten ist allerdings dasselbe 😉
* Hier können wir jedes gelesene Zeichen speichern und dann die Größe abfragen

````java
public static boolean minLaengeUndZeichen(Reader r, short l, short n) throws IOException {
        boolean gueltig;

        HashSet<Character> buchstaben = new HashSet<>();

        char[] buffer = new char[l];
        int reader = r.read(buffer);

        gueltig = reader >= l;
        
        // Wenn die Mindestlänge nicht gegeben ist, dann können wir uns das Überprüfen der Zeichen sparen ;)
        if(gueltig){

            for(int i = 0; i < l; i++){
                buchstaben.add(buffer[i]);
            }

            gueltig = buchstaben.size() >= n;
        }

        return gueltig;
    }
````
* In der for-Schleife wird jedes Zeichen im Buffer in die Collection gespeichert
  * Gleiche Zeichen werden verworfen, sodass jedes nur einmal vorkommt
  * Die for-Schleife läuft solange durch, wie wir an Zeichen prüfen wollen (hier l)
* Der Ausgabewert entspricht der Aussage ob das HashSet mindestens n Zeichen enthält

Das wäre auch die Lösung 😊