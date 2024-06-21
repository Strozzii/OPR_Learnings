# Lösung
***

Zuerst muss der Methodenkopf vervollständigt werden.

Da es sich um eine **Map** handelt, heisst es dass die gesuchte Stelle der Typ der Schlüssel darstellt.

Anhand der Abbildung sieht man, dass einem Buchstaben eine Menge an Wörter zugeordnet wird, was mit dem besagten Buchstaben beginnt.

````java
F -> [Fahrstuhl, Fahrrad]
P -> [Pfirsich]
````

Da es sich beim Schlüssel nur um ein einzelnes Zeichen handelt, wäre der Datentyp ``char`` ideal.

````java
public static Map<Character, Collection<String>> erzeugeIndex(String[] woerter)
````
* Als Lösung müssen wir ``Character`` nehmen, weil Collection-Klassen nur Objekte als Typparameter annehmen können
  * ``Character`` ist die Hüllklasse von `char` und verhält sich auch wie dieser (Es ist also nur ne Formalität)


Da es nicht auf die Anordnung ankommt, können wir als Collection ``HashMap`` benutzen
````java
public static Map<Character, Collection<String>> erzeugeIndex(String[] woerter){
        Map<Character, Collection<String>> ausgabe = new HashMap<>();

        return ausgabe;
    }
````

Nun wird es Zeit sich um die eigentliche Logik zu kümmern, um die ``ausgabe`` zu füllen.

Da wir als Parameter ein Array mit Strings haben und jedes einzelne Wort checken müssen, kommen wir nicht daran vorbei 
über das Array zu laufen. Hier bietet sich eine erweiterte for-Schleife an:

````java
for (String s : woerter) {
    char erstes_zeichen = s.charAt(0);
}
````
* Hier habe ich schon das erste Zeichen des aktuellen Strings abgespeichert, da wir es im Verlauf benötigen werden


Gehen wir mal davon aus, dass die ``ausgabe`` noch leer ist. Bedeutet, dass wir neben dem Schlüssel auch die Collection
erstellen und hinzufügen müssen, die das aktuelle Wort beinhaltet.

````java
for (String s : woerter) {
    char erstes_zeichen = s.charAt(0);
    
    HashSet<String> liste = new HashSet<>();
    liste.add(s);
    ausgabe.put(erstes_zeichen, liste);
}
````
1. Wir erstellen ein leeres ``HashSet``, was die Wörter zu einem Buchstaben speichert.
2. Diesem ``HashSet`` fügen wir das aktuelle Wort der for-Schleife hinzu.
3. Wir speichern den Eintrag in die ``HashMap`` bestehend aus dem Anfangsbuchstaben als Schlüssel und der Wörterliste als Wert.

Das würde jetzt folgende Ausgabe ergeben für Fahrrad, Fahrstuhl und Pfirsich:
````
F -> [Fahrstuhl]
P -> [Pfirsich]
````
* Da fehlt doch was :(

Da wir für **jedes** Wort ein neues ``HashSet`` erzeugen und diesen in die `HashMap` speichern, haben wir immer nur max.
1 Wort in der Liste, weil es nen bestehenden Eintrag überschreibt.

Dementsprechend müssen wir checken, ob es zu einem Anfangsbuchstaben schon einen Eintrag gibt.
* Wenn Nein, dann mach es wie grad beschrieben
* Wenn Ja, dann füge dem bestehenden ``HashSet`` das aktuelle Wort hinzu

Ergo, würde sich ja eine if-Abfrage perfekt eignen 😉


````java
for (String s : woerter) {
    char erstes_zeichen = s.charAt(0);

    if (ausgabe.containsKey(erstes_zeichen)) {
        ausgabe.get(erstes_zeichen).add(s);
    }
    else {
        HashSet<String> liste = new HashSet<>();
        liste.add(s);

        ausgabe.put(erstes_zeichen, liste);
    }
}
````

* ``ausgabe.containsKey(erstes_zeichen)`` checkt, ob in der `HashMap` sich ein Eintrag mit `erstes_zeichen` als Schlüssel
befindet.
* ``ausgabe.get(erstes_zeichen).add(s)`` holt aus der `HashMap` den Wert (also ein `HashSet`), was zum gegebenen Schlüssel passt 
  * Diesem ``HashSet`` wird dann direkt das Wort hinzugefügt durch `add(s)`

_Der vollständige Code sieht so aus:_
````java
public static Map<Character, Collection<String>> erzeugeIndex(String[] woerter){
    Map<Character, Collection<String>> ausgabe = new HashMap<>();

    for (String s : woerter) {
        char erstes_zeichen = s.charAt(0);

        if (ausgabe.containsKey(erstes_zeichen)) {
            ausgabe.get(erstes_zeichen).add(s);
        }
        else {
            HashSet<String> liste = new HashSet<>();
            liste.add(s);

            ausgabe.put(erstes_zeichen, liste);
        }

    }

    return ausgabe;
}
````

[Hier könnt ihr es ausprobieren](Main.java)