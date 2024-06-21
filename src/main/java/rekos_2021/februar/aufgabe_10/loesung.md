# Lösung
***

In dieser Aufgabe geht es darum eine bessere Version von ``filter`` zu realisieren, um mit einer Methode, mehrere Filter
einsetzen zu können.

Da diese Aufgabe freundlicherweise wieder in Teilaufgaben aufgeteilt ist, können wir diese wieder Schritt-für-Schritt 
abarbeiten.

***
## Teilaufgabe 1

**[Hier kommst du zur Schnittstelle](Filterkriterium.java)**

````java
public interface Filterkriterium {
    boolean laesstDurch(String wort);

}
````
* Das Keyword ``interface`` macht aus `Filterkriterium` eine Schnittstelle
  * Schnittstellen haben nur Methoden-Deklarationen, ohne ein Methodenrumpf
* Da es nur "entscheiden" soll, ob ein Wert durchkommt, bietet sich als Rückgabetyp ``boolean`` an
* Als Parametertyp nehmen wir logischerweise ``String``, da wir das Wort untersuchen wollen

***
## Teilaufgabe 2
**[Hier kommst du zur Methode](Listenfilter.java)**

Wir nutzen den Vorteil von der Klasse ``Stream``, die einem jedes einzelne Wort einzeln bearbeiten lässt
````java
elemente.stream()
````
* Daraus erzeugen wir aus der übergebenen Liste ``elemente`` einen Stream aus den enthaltenen Strings

````java
.filter(wort -> filter.laesstDurch(wort))
````
* Wir behalten jeden String, bei dem der Methodenaufruf ``lässtDurch`` `true` ergibt
  * ``->`` ist der Lambda-Operator, jedes `wort` wird in die Methode geworfen und das Ergebnis entscheidet

````java
.toList()
````
* Da unser Rückgabetyp ``List<String>`` sein muss, können wir den Stream in eine solche Liste konvertieren

Am Ende sieht die neue Filter-Methode so aus:
````java
public static List<String> filter(List<String> elemente, Filterkriterium filter) {
    return elemente.stream()
            .filter(wort -> filter.laesstDurch(wort))
            .toList();
}
````

***

## Teilaufgabe 3

**[So sieht eine Klasse mit einem Kriterium aus](LaengenFilter.java)**

````java
public class LaengenFilter implements Filterkriterium {
    @Override
    public boolean laesstDurch(String wort) {
        return wort.length() > 10;
    }
}
````

* Die Schnittstelle ``Filterkriterium`` muss implementiert werden
  * Das zwingt uns dazu, die Methode ``laesstDurch`` zu überschreiben

````java
return wort.length() > 10;
````
* Hier kriegen wir immer ``true``, wenn das übergebene Wort mehr als 10 Zeichen hat