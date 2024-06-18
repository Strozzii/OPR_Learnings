# Lösung
***

## Disclaimer

Bevor ich zur Lösung komme, will ich kurz erwähnen, dass solche Aufgaben sehr angsteinflößend wirken können, aber
man kann hier sehr gut Teilpunkte bekommen, da man hier 4 Teilaufgaben hat, die man isoliert bearbeiten kann; auch wenn
man eine Aufgabe nicht rafft. Aber wichtig ist aufjedenfall die Aufgaben in Ruhe durchzulesen, da dort meistens Tipps
versteckt sind, wie man die Aufgabe lösen kann.

## 1) Schnittstelle erstellen

Um eine Schnittstelle zu definieren gibt es das Keyword `interface` statt `class`:

````java
public interface Messwertverarbeiter {}
````

Da jeder `Messwertverarbeiter` eine Methode haben soll, die einen Messwert verarbeiten soll, bietet sich Folgendes an:

````java
public interface Messwertverarbeiter {
    void verarbeite(Messwert m);
}
````
* Mit Messwert ist ein Objekt der Klasse `Messwert` gemeint
  * Diese ist im Aufgabentext gegeben!


## 2) Verwendung der Schnittstellen

Hier soll Code ergänzt werden, damit die Klasse `Messwertekeser` auch den `Messwertverarbeiter` benutzen kann.

Dafür benötigen wir folgende Dinge:
* Die Klasse `Messwerteleser` muss eine **Instanzvariable** haben, die einen `Messwertverarbeiter` speichert
````java
private Messwertverarbeiter m;
````
* Dieser muss dann auch im **Konstruktor** initialisiert werden
````java
public Messwerteleser(Reader r, Messwertverarbeiter m){
    this.r = r;
    this.m = m;
}
````
* Wenn `Messwerteleser` seine `lies`-Methode ausführt, dann sollen die gelesenen Messwerte an den `Messwertverarbeiter`
übergeben werden, damit dieser auch seine Arbeit machen kann
  * Hierfür reicht einfach in der `lies`-Methode den `Messwertverarbeiter` und seine definierte Methode auszuführen
````java
public void lies(){
    while(this.gibtEsWeiterenMesswert()){
        Messwert wert = this.gibNaechstenMesswert();
        this.m.verarbeite(wert);    // Das kam dazu
    }
 }
````


## 3) Schnittstelle implementieren und besondere Messwerte filtern

Diese Teilaufgabe gehört zu den umfangreichsten, da hier eine ganze Klasse geschrieben werden muss, deswegen kann man
diese Aufgabe auch wieder in Teilschritten bearbeiten:

#### "Realisieren Sie eine Klasse HitzeOrt, die diese Schnittstelle implementiert"
````java
public class HitzeOrt implements Messwertverarbeiter {}
````

* Da wir hier eine Schnittstelle implementieren, müssen wir auch die vorher festgelegte Methode aus 1) überschreiben
````java
public class HitzeOrt implements Messwertverarbeiter{
    @Override
    public void verarbeite(Messwert m) {
        // Hier Logik
    }
}
````
* Bevor wir `verarbeite(Messwert)` überschreiben sollten wir uns aber über die Klasse an sich Gedanken machen

#### "Ein Objekt dieser Klasse zählt bezogen auf einen einzelnen Ort, wieviele Temperaturwerte oberhalb eines bestimmten Schwellwerts liegen."

* Hier müssen uns auf drei wesentliche Attribute beziehen, die im Text erwähnt werden:
  * "... zählt bezogen ..., wieviele Temperaturwerte ..."
  * "... einen einzelnen Ort, ..."
  * "... oberhalb eines bestimmten Schwellwerts ..."
* Diese drei Attribute können wir uns auch als Instanzvariablen denken
````java
private int anzahl;
private float schwellwert;
private String ort;
````

#### "Im Konstruktor von HitzeOrt wird der Ort und der Schwellwert übergeben."

* Da wir immer von 0 aus zählen, macht es keinen Sinn einen weiteren Parameter zu definieren für die Anzahl
````java
public HitzeOrt(float schwellwert, String ort){
    this.schwellwert = schwellwert;
    this.ort = ort;
    anzahl = 0;
}
````

#### "Sie benötigen natürlich auch eine Zugriffsmethode für den Zählwert."

* Hierbei ist eine Getter-Methode gemeint, damit man von Außen Zugriff auf die Anzahl der gefilterten Messwerte hat
````java
public int gibAnzahl(){
    return anzahl;
}
````

### Jetzt müssen wir uns noch um die `verarbeite`-Methode kümmern!
* Die Anzahl soll immer um 1 hochgehen, wenn der Ort des `Messwert`-Objektes mit der Instanzvariable `ort` übereinstimmt
und die gemessenene Temperatur **echt größer** als die Instanzvariable `schwellwert` ist
````java
@Override
public void verarbeite(Messwert m) {
    if(this.ort == m.gibOrt() && this.schwellwert < m.gibTemperatur()){
        anzahl++;
    }
}
````
* Die Getter-Methoden von `Messwert` sind vorgegeben
````java
public class Messwert {
...
public String gibOrt() {...}
public Datum gibZeitpunkt() {...}
public float gibTemperatur() {...}
}
````

### Am Ende sieht die Klasse `Hitzeort` so aus:
````java
public class HitzeOrt implements Messwertverarbeiter{

    private int anzahl;
    private float schwellwert;
    private String ort;

    public HitzeOrt(float schwellwert, String ort){
        this.schwellwert = schwellwert;
        this.ort = ort;
        anzahl = 0;
    }

    public int gibAnzahl(){
        return anzahl;
    }

    @Override
    public void verarbeite(Messwert m) {
        if(this.ort == m.gibOrt() && this.schwellwert < m.gibTemperatur()){
            anzahl++;
        }
    }
    
}
````

## 4) Codestück ergänzen
Die zwei "größeren" Lücken sind deswegen da, da man mehrere Ansätze gehen kann, wie man die Aufgabe löst. Eig braucht man
nur eine Lücke zum beschreiben.

Bevor wir den `Messwerteleser` erzeugen, müssen wir zuerst unseren `Messwertverarbeiter` erzeugen, damit wir den direkt
als Argument übergeben können:

````java
Messwertverarbeiter hitzeort = new HitzeOrt(38, "Bonn");
````
* Nur Messwerte in Bonn mit über 38 Grad Temperatur sind relevant

Den können wir jetzt als Argument übergeben:
````java
Messwerteleser leser = new Messwerteleser(r,hitzeort);
````

Darauf kann die `lies`-Methode direkt ausgeführt werden und gefordert ist, wie man nun an die Anzahl kommt:
````java
leser.lies();
System.out.println("Hitze-Messwerte in Bonn: " + ((HitzeOrt) hitzeort).gibAnzahl());
````
* Warum der Typecast?
  * Der Variablentyp ist `Messwertverarbeiter`. Dieser kennt die Methode `gibAnzahl()` nicht, deswegen muss es in ein
Hitzeort-Objekt konvertiert werden.
* Hätte man nicht als Typen einfach von Anfang an `Hitzeort` nehmen können?
  * Ja aufjedenfall, aber ich bin ein Freund vom abstrakteren Typen, damit man im "Notfall" eine andere Strategie wählen
kann, als jetzt den HitzeOrt. (Also ist halt nachhaltiger Code)

***
Wenn man kleinschrittig an die ganze Sache rangeht, dann kann man echt viele Teilpunkte rausholen 😊