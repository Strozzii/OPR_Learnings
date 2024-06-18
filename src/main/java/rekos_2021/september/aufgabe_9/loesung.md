# Lösung
***

In dieser Aufgabe geht um funktionale Schnittstellen basierend auf diesen Zeilen Code:

````java
@FunctionalInterface
public interface PINregel {
    boolean istZulaessig(String pin);
}
````
* Die Annotation `@FunctionalInterface` kann man eig auch weglassen, aber es soll signalisieren, dass die Schnittstelle
nur **EINE** Methode definieren soll
  * Grund ist, dass man so die Implementierung flexibel gestalten kann durch den Lambda-Ausdruck
  * So braucht es keine extra Klassen, die die Schnittstelle implementieren

Bei beiden Aufgaben geht es darum durch `setzePINregel(PINregel)` eine Regel aufzustellen, gemäß der Aufgaben.
Anstatt man nun eine extra Klasse erstellt, die `PINregel` implementiert, kann nun Folgendes machen:
````java
ob.setzePINregel( pin -> ... );
````
* `x` beschreibt hier das Argument, was sich mit dem Parameter von `istZulaessig(String)` deckt.
  * Somit handelt es sich hier um den PIN der überprüft werden soll

Rechts vom Lambda-Operator `->` muss dann eine Anweisung stehen, was die Implementierung von `istZulaessig` darstellen soll
Also quasi der `return`-Wert.

### 1)
````java
ob.setzePINregel(pin -> pin.length() >= 5 && pin.charAt(0) != pin.charAt(pin.length() - 1));
````
* Zwei Bedingungen müssen gleichzeitig erfüllt sein
  * Der PIN hat mindestens die Länge 5
  * Das erste und letzte Zeichen sind ungleich


### 2)
````java
ob.setzePINregel(pin -> false);
````
* Das ist das Äquivalent zu `return false;`
  * Dementsprechen wird `pin` eig nicht gebraucht, muss aber tzd hier angegeben werden
  * Dadurch sind **ALLE** PINS unzulässig