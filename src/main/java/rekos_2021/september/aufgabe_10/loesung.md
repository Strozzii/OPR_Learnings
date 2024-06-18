# Lösung
***

Kurze Erklärung was die drei Methoden unten machen, die als Tipp angegeben sind:
* `lines()`
  * Jede Zeile der Datei, die im ``BufferedReader`` wird separiert und als eigenes Stream-Element behandelt
  * Dementsprechend liefert die Methode einen Stream aus den Zeilen der Datei
* ``endswith(String)``
  * Wahrheitswert, ob ein String mit dem übergebenen String endet (Case-Sensitive)
* ```stripTrailing()```
  * Liefert den gleichen String, nur ohne Leerzeichen

Da wir unsere Werkzeuge kennen, können wir nun mit der Strategie anfangen:
1. Zuerst nehmen wir den Reader und erzeugen daraus einen Stream mit den einzelnen Zeilen als Elemente.
2. Wir löschen alle Zeilen, die nicht mit "@" beginnen.
3. Wir eliminieren sämtliche Leerzeichen, da diese am Ende der Zeile ignoriert werden können.
4. Suchen nach einer Zeile, die mit "aha" endet (Groß-/Kleinschreibung egal)

````java
r.lines()
````
* Hierdurch erhalten wir einen Stream, welcher alle Zeilen beinhaltet

````java
.filter(s -> s.startsWith("@"))
````
* Wir löschen alle Zeilen mit `filter()`, außer die, wo die boolsche Bedinung ``true`` ist
  * Das in den Klammern nennt sich ```Predicate```
  * Das ``s`` bezieht sich immer auf die einzelnen Zeilen

````java
.map(s -> s.stripTrailing())
````
* ``map()`` ist dazu da um auf die einzelnen Stream-Elemente eine Funktion anzuwenden, um sie nach eigenem Ermessen zu bearbeiten
  * Hierbei wird jede Zeile ``s`` die `stripTrailing`-Methode angewendet um die Leerzeichen zu eliminieren

````java
.anyMatch(s -> s.toLowerCase().endsWith("aha"));
````
* ``anyMatch()`` gibt einen Wahrheitswert zurück, der aussagt ob mindestens **eine** Zeile die Bedingung (`Predicate`) erfüllt
  * Da die Groß-/Kleinschreibung egal ist, wandeln wir den gesamten String in Kleinbuchstaben um und überprüfen, ob am Ende "aha" (in Klein) steht


### Lösung:
````java
 r.lines()
        .filter(s -> s.startsWith("@"))
        .map(s -> s.stripTrailing())
        .anyMatch(s -> s.toLowerCase().endsWith("aha"));
````