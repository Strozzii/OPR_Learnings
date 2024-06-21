# Lösung
***

## Wie funktionieren TreeSets?

TreeSets haben die Eigenschaft, dass die Elemente in einer bestimmten Reihenfolge ausgegeben werden. (In HashSets haben
Elemente keine spezifische Reihenfolge).

Ein TreeSet kann allerdings nur mit Objekten funktionieren, die in der Lage sind, sich mit Objekten des selben Typs zu
vergleichen. (Strichwort: `compareTo`)

Damit Klassen diese Methode sinnvoll anwenden können, müssen sie eine bestimmte Schnittstelle implementieren. Und zwar
das Interface ``Comparable<T>``
* Das ``<T>`` steht für den Typen, mit dem sich die Klasse vergleichen können soll

Die Klassen selber sorgen dann beim Überschreiben von ``compareTo``, dass sich Objekte beim Vergleichen richtig verhalten.

***

## Implementierung

````java
public class Rechteck implements Comparable<Rechteck> {
    private int breite;
    private int hoehe;

    public Rechteck(int breite, int hoehe) {
        this.breite = breite;
        this.hoehe = hoehe;
    }

    @Override
    public int compareTo(Rechteck r) {
        // ... Hier kommt Logik rein
    }
    
}
````
* Mit ``<Rechteck>`` sagen wir der Klasse, dass sie sich mit Rechtecken vergleichen können soll
* Der Rückgabetyp ``int`` von `compareTo` beschreibt, ob das aktuelle Objekt größer oder kleiner ist, als das Übergebene

````java
@Override
public int compareTo(Rechteck r) {
    int vergleichswert;

    vergleichswert = r.hoehe - this.hoehe;

    return vergleichswert;
}
````

Hier ist wichtig zu verstehen, was ``vergleichswert`` im Vergleichskontext bedeutet:

Ist der Wert:
* Positiv, dann bedeutet es, dass ``this`` **größer** ist, als `r`
* Negativ, dann bedeutet es, dass ``this`` **kleiner** ist, als `r`
* 0, dann bedeutet es, dass ``this`` **gleichgroß** wie `r` ist

So wie ich es gelernt habe:

Das TreeSet versucht immer in aufsteigender Reihenfolge zu sortieren. Wenn wir ihm vorgaukeln, dass bei einem größeren
``this``-Objekt ein negativer Wert rauskommt, würde er dieses Objekt an erstere Stelle setzen.
````java
vergleichswert = r.hoehe - this.hoehe;
````
* Dementsprechend würde hier ein großes ``this`` eine negative Zahl ergeben, was es dann an erste Stelle setzt

Da es aber auch vorkommen kann, dass ``hoehe`` gleichgroß sein kann, müssen wir auch die `breite` berücksichtigen
und in dem Fall aufsteigend sortieren. Hier eignet sich eine if-Abfrage:

````java
 @Override
public int compareTo(Rechteck r) {
    int vergleichswert;

    vergleichswert = r.hoehe - this.hoehe;

    if (vergleichswert == 0){
        vergleichswert = this.breite - r.breite;
    }

    return vergleichswert;
}
````
````java
vergleichswert = this.breite - r.breite;
````
* Analog zum Höhenvergleich, haben wir beide Ausdrücke getauscht um bei einem großen ``this`` eine positive Zahl zu bekommen
  * Dadurch wirds als größer interpretiert und an letzte Stelle gepackt

**[Schau es dir hier an](Rechteck.java)**

***
## Zusatzpunkte

Für die Zusatzpunkte sollen Objekte nicht mehrfach im Set enthalten sein. Dafür müssen wieder ``hashCode`` und ``equals``
überschrieben werden.


````java
@Override
public int hashCode() {
    return (hoehe + 69) * (breite * 420);
}

@Override
public boolean equals(Object o) {
    boolean isEqual = false;

    if (o instanceof Rechteck r) {
        isEqual = (this.breite == r.breite) && (this.hoehe == r.hoehe);
    }

    return isEqual;
}
````
* In ``hashCode`` wird noch mit zufälligen Zahlen addiert, damit (Breite:4, Höhe:2) nicht denselben HashCode hat, wie
  (Breite:2, Höhe4)
  * Unter Umständen kann es mathematisch doch vorkommen, dass zwei denselben Hashcode haben. Aber sehr unwahrscheinlich
* ``equals`` wurde analog zu [Aufgabe 4](../aufgabe_4) bearbeitet








