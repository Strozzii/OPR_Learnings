# Lösung

[Hier kommst Du zum Code](Zeichenobjekt2D.java)
***

## Anforderung 1

"Man kann keine Objekte ... erzeugen"

Um diese Anforderung zu erfüllen muss eine Klasse **abstrakt** sein. Das bedeutet, dass die Klasse "nicht komplett" 
implementiert wurde. Dadurch erreicht man, dass mit `new Klasse()` kein neues Objekt erzeugt werden kann.

```java
public abstract class Zeichenobjekt2D {}
```

***

## Anforderung 2
"... enthält keine Instanzvariable."

Es ist so einfach, wie man es sich eigentlich denkt: Man schreibt einfach keine Instanzvariablen hin. Hat auch den
praktischen Hintergrund, weil ein Zeichenobjekt z.B. ein Kreis oder ein Rechteck sein kann und jeweils nur einer eine 
Eigenschaft "Radius" hätte. Dementsprechend verlässt sich die Oberklasse darauf, dass die Kindklassen sich um ihre
Instanzvariablen kümmern.

***

## Anforderung 3

Das ist etwas anspruchsvoller, da hier mehr als nur eine Methode implementiert werden muss. Aber was ist eigentlich
eine Template-Methode?


