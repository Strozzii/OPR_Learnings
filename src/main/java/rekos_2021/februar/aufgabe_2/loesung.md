# Lösung
***

Die Antwort ist **Ja**.

## Begründung

Der Grund ist der Konstruktor in ``A``.
````java
public A(int a) {
    this.a = a;
}
````
* Man beachte die Parameterklammern, da hier der Konstruktor einen Integer erwartet

Gucken wir uns eine Unterklasse von ``A`` an ohne Konstruktor, namens ``AA``:
````java
public class AA extends A {}
````

In diesem Kontext gibt es zwei Regeln, die Klassen in Java zu befolgen haben:
1. Jede Klasse benötigt einen Konstruktor.
2. Jede Kindklasse muss beim Erzeugen den Konstruktor der direkten Elternklasse aufrufen.

Was Java macht ist, dass wenn wir keinen Konstruktor definiert haben, es der Klasse automatisch einen **Standardkonstruktor** spendiert.

Bedeutet, dass jede Klasse zunächst immer so aussieht:

````java
public class AA extends A{
    public AA() {}
}
````

Was noch fehlt ist, dass eine Kindklasse den Elternklassen-Konstruktor aufrufen muss. Dies passiert durch die Anweisung
```super()```. Wenn man diese Anweisung nicht explizit schreibt, übernimmt das auch Java.

````java
public class AA extends A{
    public AA() {
        super();
    }
}
````
* Java platziert **immer** ``super`` ohne Argumente
  * Und hier wird klar, warum man explizit einen Konstruktor implementieren muss

Der ``super()``-Aufruf kann nicht den Konstruktor von `A` aufrufen, da dieser einen Parameter hat.
(Die Signatur von `super()` passt also nicht zum Konstruktor der Elternklasse)

Eine Lösung wäre einfach einen Integer zu übergeben
````java
public AA() {
    super(42);
}
````

oder der Kindklasse auch einen Parameter zu verpassen
````java
public AA(int a) {
    super(a);
}
````

### Zusammengefasst

Ja, weil der Java-Compiler in der Kindklasse automatisch einen Standardkonstruktor hinzufügen würde, der zusätzlich die
Anweisung ``super()`` hinzufügt, welcher den Konstruktor der Elternklasse aufruft. Da die Signatur nicht zum Konstruktor
von ``A`` passt, würde es zu einem Fehler kommen. Dementsprechend muss explizit ein Konstruktor definiert werden, wo man
dann explizit ``super(int)`` aufruft mit dem passenden Argument.

***

## Funfact

In Java ist **jede Klasse** eine Kindklasse bis auf ``Object``.

Falls eine Klasse nicht explizit von einer anderen Klasse erbt, erbt sie automatisch von ``Object``.
Dementsprechend ruft jede Klasse in ihrem Konstruktor ``super()`` auf, was der Signatur des Konstruktors in `Object` entspricht.

So sieht jede "leere" Klasse aus, ohne Konstruktor und Elternklasse:
````java
public class A extends Object {
    public A() {
        super();
    }
}
````
* Dementsprechend erbt auch jede Klasse die Methoden von ``Object`` wie z.B. `hashCode` oder `equals`