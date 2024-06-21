# Lösung
***

## Anforderung 1

``"Man kann keine Objekte ... erzeugen."``

**Generell gilt:**

Soll von es von einer Klasse keine Objekte geben (weil z.B. nur ein Grundgerüst für andere Klassen sein soll), dann ist
nötig diese Klasse als _abstrakt_ zu deklarieren. Das erreicht man durch das Keyword ``abstract``.

````java
public abstract class Zeichenobjekt {}
````
* Das "deaktiviert" sozusagen den Konstruktor, sodass ``new Zeichenobjekt()`` nicht funktionieren kann.

***
## Anforderung 2

``"... enthält keine Instanzvariable.``

Bedeutet, dass die Kindklassen selbst ihre Variablen verwalten/bestimmen müssen. Heisst in ``Zeichenobjekt`` müssen wir
nichts hinzufügen.

***
## Anforderung 3

``"Jedes Objekt einer ... abgeleiteten Klasse kann durch die Methode angeben ..."``

Hier geht es darum, eine _Template-Methode_ zu implementieren.

Eine Template-Methode ist eine, in der Elternklasse, feststehende Methode, die an die Kindklassen vererbt werden soll.
(Zum Beispiel um eine feststehendes Verhalten der Klasse festzulegen)

Die Definition sieht hier wie üblich aus:

````java
public boolean istGroesser(Zeichenobjekt zeichenobjekt) {}
````

Da wir hier den Flächeninhalt der Zeichenobjekte (Rechteck, Kreis, etc) vergleichen, können wir einfach einen
boolschen Ausdruck implementieren, der ```true``` liefert, wenn das aktuelle (``this``) Objekt eine echt größere Fläche
besitzt, als das übergebene Zeichenobjekt (in den Parameterklammern).

````java
public boolean istGroesser(Zeichenobjekt zeichenobjekt){
    return this.flaecheninhalt > zeichenobjekt.flaecheninhalt;
}
````
* Ab diesem Moment kriegt ihr einen **Fehler**, weil was ist ``flaecheninhalt``?
  * Da sich keine Instanzvariablen in der abstrakten Klasse befindet, die sicherstellt, dass jede Kindklasse auch eine Variable ``flächeninhalt`` besitzt, kriegen wir hier einen Fehler
  * ``Zeichenobjekt`` kennt nämlich die Variable `flaecheninhalt` zu dem Zeitpunkt einfach nicht

Hier lohnt es sich im ersten Schritt sog. _Getter-Methoden_ zu etablieren.

````java
public boolean istGroesser(Zeichenobjekt zeichenobjekt){
    return this.getGroesse() > zeichenobjekt.getGroesse();
}
````
* Hier kommen wir zum selben Fehler, aber diesmal haben wir keine Instanzvariablen benutzt, sondern einen Methodenaufruf, der den Flächeninhalt des aufrufenden Objekts zurückgibt

Da wir neben den drei Anforderungen frei im Design sind, können wir einfach weitere Methoden hinzufügen.
Wir wollen zwei Dinge:
1. Jede Kindklasse soll eine Getter-Methode implementieren, die zum Objekt den Flächeninhalt zurückgibt.
2. Da die Berechnung für jedes Zeichenobjekt unterschiedlich ist, muss jede Kindklasse sich selber um die Berechnungsvorschrift kümmern.

````java
public abstract double getGroesse();
````

* ``abstract`` als Keyword ohne Methodenrumpf
  * Kindklassen werden gezwungen, diese Methode zu überschreiben
  * Damit ist gewährleistet, dass in ``istGroesser`` der Flächeninhalt bekannt ist durch die Getter-Methode

Somit sieht die Klasse ``Zeichenobjekt`` wie folgt aus:

````java
public abstract class Zeichenobjekt {

    public boolean istGroesser(Zeichenobjekt zeichenobjekt){
        return this.getGroesse() > zeichenobjekt.getGroesse();
    }

    public abstract double getGroesse();
}
````

[Hier kannst du den Code testen](Main.java)


***
## Funfact

Es lohnt sich auch oft, Template-Methoden "zu schützen", indem sie nicht überschreibbar sind.
Das kann man durch das Keyword ``final`` erreichen.

````java
public final boolean istGroesser(Zeichenobjekt zeichenobjekt)
````