# Lösung
***
## Vorbereitung
Da das für die Aufgabe wichtig ist, sollten wir zuerst die Umrechnungsfaktoren bestimmen, also den Faktor um von einer
Einheit zur nächsten zu kommen.
*  1000 µm = 1 mm
*  10 mm = 1 cm
*  10 cm = 1 dm
*  10 dm = 1 m
*  1000 m = 1 km 


km ist die größte Einheit!

## Implementierung
Solche Aufgaben kann man oft in zwei Teile aufteilen:
1. Konstruktor und Variablen
2. Implementierung der Methode

### Konstruktor und Variablen
Man kann hier schon sehr viele Punkte rausholen, weshalb man sich dringend anschauen sollte, wie Aufzählungen 
funktionieren, da sie leicht anders aussehen als gewöhnliche Klassen!

* Man benötigt zuerst die Enumeration als Ganzes durch das Keyword `enum`
````java
public enum Einheit {}
````

* Instanzvariable ganz wichtig. Da kommt der Umrechnungsfaktor ins Spiel
````java
private final int faktor;
````

* Als Nächstes kommt der Konstruktor dran
  * Hier ist der Modifikator `public` unnötig, weil der Konstruktor **nur** innerhalb dieser Klasse aufgerufen wird
  * Da der Umrechnungsfaktor als einzige eine Rolle spielt, benötigen wir auch nur ein Argument übergeben
````java
Einheit(int factorToNext) {
    this.faktor = factorToNext;
}
````

* Was jetzt Enum-typisch ist, ist dass wir nun die Aufzählungstypen konstruieren mit ihren Umrechungsfaktoren zur
nächsten Einheit
  * Das hier sieht untypisch aus, hat aber alles seine Richtigkeit
  * Die Zahlen innerhalb der Klammern repräsentieren die Umrechnungsfaktoren zur nächsten Einheit
````java
MUM(1000),
MM(10),
CM(10),
DM(10),
M(1000),
KM(1);
````

Insgesamt haben wir also:

````java
public enum Einheit {
    MUM(1000),
    MM(10),
    CM(10),
    DM(10),
    M(1000),
    KM(1);

    private final int faktor;
    
    Einheit(int factorToNext) {
        this.faktor = factorToNext;
    }

}
````

### Implementierung der Methode

Hierbei geht es darum bei einer Einheit und gegebenen Zahl, die bestmöglichste Einheit zu bekommen, sodass die Zahl
möglichst **klein** und **ganzzahlig**.

````java
public Einheit geeigneteEinheit(long z) {}
````

So sieht der Aufruf dann aus mit gewünschtem Ergebnis:
````java
CM.geeigneteEinheit(12000); // Meter ist am besten, da in Kilometer die Zahl kleiner als 1 wäre
MM.geeigneteEinheit(2_000_000);  // Kilometer ist hier ideal
````

Bei Enumerationen gibt es paar Methoden die man kennen sollte, die einem das Leben sehr erleichtern, wie z.B.:
* `values()`
  * Gibt alle Enum-Konstanten (Hier: MUM, MM, usw.) als Array zurück
* `ordinal()`
  * Gibt den Index einer Enum-Konstante zurück (z.B. CM hat die Ordinalszahl 2, weil es als drittes in der Reihe oben ist)

Da wir durch alle Enum-Konstanten iterieren müssen, um zu prüfen, welche für meine Zahl am geeignetsten ist, müssen wir
diese als Array vorliegen haben, da dies durch die Enumeration sonst nicht möglich ist. Hierbei bleibt der Arraytyp `Einheit`.
````java
Einheit[] einheiten = Einheit.values();
````

Da es auch keinen Sinn macht bei einer kleineren Einheit zu prüfen, ob sie geeignet ist (da die Zahl dadurch größer und
unleserlicher wird) sollten wir auch den Index unserer aktuellen Einheit abspeichern, um dann von da aus die größeren
Einheiten zu überprüfen.
````java
int index = this.ordinal(); // this beschreibt die aktuelle Einheit
````

Um eine geeignete Einheit zu finden, wäre es günstig ab der Ordinalszahl (also `index`) das Array zu durchsuchen und die
aktuelle Zahl durch den aktuellen Umrechungsfaktor zu dividieren. 

````java
while (index < einheiten.length - 1) {
    long naechste_zahl = aktuelle_zahl / einheiten[index].faktor;

    index++;
}
````
* `naechste_zahl` beschreibt die gegebene Zahl in der nächstgrößeren Einheit

Darauf sollte geprüft werden, ob die Zahl immernoch ganzzahlig ist. Wenn nicht, dann brich die Schleife ab mit `break`,
da wir dann unsere Einheit gefunden haben.
````java
while (index < einheiten.length - 1) {
    long naechste_zahl = aktuelle_zahl / einheiten[index].faktor;
    if (naechste_zahl < 1) {
        break;
    }
    aktuelle_zahl = naechste_zahl;
    index++;
}
````
* ``naechste_zahl`` wird zur aktuellen Zahl, da wir dann die nächstgrößere Einheit überprüfen können 

Da die letzte Position unseres Indizes Aufschluss darüber gibt, was unsere geeignete Einheit ist, können wir die auch
benutzen, um die Einheit als Rückgabewert zurückzugeben.

````java
return einheiten[index];
````

Insgesamt haben wir dann folgenden Code:
````java
public enum Einheit {
    MUM(1000),
    MM(10),
    CM(10),
    DM(10),
    M(1000),
    KM(1);

    private final int faktor;


    Einheit(int factorToNext) {
        this.faktor = factorToNext;
    }

    public Einheit geeigneteEinheit(long aktuelle_zahl) {
        Einheit[] einheiten = Einheit.values();
        int index = this.ordinal();

        while (index < einheiten.length - 1) {
            long naechste_zahl = aktuelle_zahl / einheiten[index].faktor;
            if (naechste_zahl < 1) {
                break;
            }
            aktuelle_zahl = naechste_zahl;
            index++;
        }

        return einheiten[index];
    }
}


````

````java
public static void main(String[] args) {
    System.out.println(CM.geeigneteEinheit(12000));
    System.out.println(MM.geeigneteEinheit(2_000_000));
}
````
gibt euch als Ausgabe:
````
M
KM
````

Das wäre auch die Lösung! 🙂


***
### Funfact
Eine Enumeration als Rückgabetyp kann man direkt in `System.out.println()` ausgeben lassen, da die String-Repräsentation
des Aufzählungstyps ausgegeben wird.

````java
System.out.println(MM.geeigneteEinheit(2_000_000));
````

bringt die Ausgabe:
````
KM
````
