# Lösung
***
## Vorbereitung

Es soll eine herkömmliche Klasse ``Zeitdauer`` realisiert werden mit Stunden und Minuten als Instanzvariablen.

````java
public class Zeitdauer {
    private int stunden;
    private int minuten;

    public Zeitdauer(int stunden, int minuten) {
        this.stunden = stunden;
        this.minuten = minuten;
    }
}
````
* Das sollte jeder hinbekommen 😂

***
## Anforderung 1

Es geht darum, einen Fehler auszuwerfen, wenn die Parameter nicht größer gleich 0 sind, um negative Zeitangaben zu
vermeiden. Bedeutet das folgende Anweisung einen Fehler ausgeben soll:
````java
new Zeitdauer(4, -2);
````
* Dementsprechend müssen wir etwas am Konstruktor verändern!

Um einen Fehler zu "werfen" kann man das Schlüsselwort ``throw`` benutzen gefolgt von der Exception die geworfen werden
soll. Da es hier auf die Bedingung ankommt, dass einer der Parameter negativ ist, bietet sich eine if-Abfrage an:

````java
public Zeitdauer(int stunden, int minuten) {
    if (stunden < 0 || minuten < 0){
        throw new IllegalArgumentException("Stunde und Minute müssen größer gleich 0 sein!");
    }

    this.stunden = stunden;
    this.minuten = minuten;
}
````
* Man kann auch Exception nehmen, aber ein besserer Stil ist es einen spezifischen Fehler zu werfen, der zum Kontext passt

Nun taucht folgende Ausgabe auf, wenn man negative Parameter hat:
````
Exception in thread "main" java.lang.IllegalArgumentException: Stunde und Minute müssen größer gleich 0 sein!
	at rekos_2021.februar.aufgabe_4.Zeitdauer.<init>(Zeitdauer.java:13)
	at rekos_2021.februar.aufgabe_4.Zeitdauer.main(Zeitdauer.java:47)
````

***

## Anforderung 2

In jeder Aufgabe, wo es darauf ankommt, dass Objekte in einem ``HashSet`` niemals mehrfach auftauchen, muss man immer
zwei Methoden (geerbt von ``Object``) überschreiben:
1. ``int hashCode()``
2. ``boolean equals(Object)``

Der Hashcode ist sowas wie der digitale Fingerabdruck eines Objektes. Die Standard-Implementierung sorgt dafür, dass
selbst Objekte mit den gleichen Werten einen anderen Fingerabdruck. Im Sinne von ``HashSets`` und der Vergleichbarkeit,
bietet es sich an die oben genannten Methoden zu überschreiben.

````java
@Override
public int hashCode(){
    return stunden * 60 + minuten;
}
````
* Wir sorgen dafür, dass sich der Hashcode aller Zeitdauer-Objekte aus den ganzen Minuten ergibt
  * Damit hat 1h 100m den gleichen Fingerabdruck wie 2h 40m

Um aber auch über die ``equals``-Methode, die von Collection-Klassen verwendet werden, zu nutzen um zwei Objekte zu vergleichen,
müssen wir diese auch vergleichen:

````java
@Override
public boolean equals(Object o) {
    boolean isEqual = false;

    if (o instanceof Zeitdauer z){
        isEqual = (this.stunden * 60 + this.minuten) == (z.stunden * 60 + z.minuten);
    }

    return isEqual;
}
````
* Wie bei ``hashCode`` verwenden wir die ganzen Minuten und vergleichen sie des aktuellen Objektes mit dem Übergebenen
* ``instanceof`` sorgt dafür, dass wir auch nur Zeitdauer-Objekte vergleichen können

So sieht dann die gesamte Lösung aus:

````java
import java.util.HashSet;

public class Zeitdauer {

    private int stunden;
    private int minuten;

    public Zeitdauer(int stunden, int minuten) {

        if (stunden < 0 || minuten < 0) {
            throw new IllegalArgumentException("Stunde und Minute müssen größer gleich 0 sein!");
        }

        this.stunden = stunden;
        this.minuten = minuten;

    }

    @Override
    public int hashCode() {
        return stunden * 60 + minuten;
    }

    @Override
    public boolean equals(Object o) {
        boolean isEqual = false;

        if (o instanceof Zeitdauer z) {
            isEqual = (this.stunden * 60 + this.minuten) == (z.stunden * 60 + z.minuten);
        }

        return isEqual;
    }
}
````

[Hier könnt ihr es testen!](Zeitdauer.java)