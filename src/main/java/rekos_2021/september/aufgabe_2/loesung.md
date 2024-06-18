# Lösung
***

### 1) Lässt sich die Klasse _Buch_ fehlerfrei compilieren, wenn in der Klasse _Katalogartikel_ kein Konstruktor definiert ist?

#### Ja!

Dazu muss man wissen was folgende Begriffe bedeuten:
* Standard-Konstruktor
* `super()`

Jede Klasse ohne einen vom Programmierer definierten Konstruktor erhält beim Compilieren einen
sogenannten "Standard-Konstruktor" der wie folgt in Klasse _Katalogartikel_ aussieht:

````java
public class Katalogartikel {
    
    // Es handelt sich immer um einen leeren Konstruktor
    public Katalogartikel(){

    }

}
````
Dementsprechend besitzt jede Klasse immer einen Konstruktor... Egal ob man einen schreibt oder nicht.

Eine wichtige Eigenschaft in Java (und eig auch jeder anderen objektorientieren Programmiersprache)
ist, dass eine Kindklasse im Konstruktor immer zuerst den Konstruktor der Elternklasse aufruft.
Das trifft auf jede Klasse zu, da jede Klasse eine Kindklasse von _Object_ ist.
Der Aufruf des Konstruktors erfolgt durch `super()`.

Wie beim Standard-Konstruktor, ergänzt der Compiler diese Anweisung beim Compilieren und setzt sie **immer**
in die erste Zeile des Konstruktors. Das sieht dann so aus in der Klasse _Buch_ und _Katalogartikel_:

````java
// Konstruktor der Klasse Buch
public Buch(String titel, String autor, int jahr){
        super(); // Diese Zeile ergänzt der Compiler
        this.titel = titel;
        this.autor = autor;
        this.jahr = jahr;

}
````

````java
// Konstruktor der Klasse Katalogartikel
public Katalogartikel(){
    super(); // Diese Zeile ergänzt der Compiler, weil Katalogartikel Kindklasse von Object ist
}
````

Da nun ersichtlich ist, dass Buch den (Standard) Konstruktor von Katalogartikel aufruft, sieht man schon, dass
es keine Probleme geben kann, weil:
* `super()` in Buch wird aufgerufen ohne Argumente
* Der (Standard) Konstruktor in Katalogartikel erwartet keine Argumente

Dementsprechend kann die Klasse Buch fehlerfrei compiliert werden! 😉

### 2) Ist es möglich, dass in der Klasse Katalogartikel ein Konstruktor definiert ist und sich die Klasse Buch nicht fehlerfrei compilieren lässt?

#### Ja!

Und zwar, wenn der definierte Konstruktor Parameter besitzt, wie folgt:

````java
// Konstruktor in Klasse Katalogartikel
public Katalogartikel(int x){
    
}
````

Dadurch kann der in Aufgabe 1 erklärte `super() - Aufruf` nicht funktionieren, da dieser keine Argumente übergeben bekommt.
Um das Problem zu lösen, muss der Programmierer explizit diesen Aufruf mit Argumenten einsetzen:

````java
// Konstruktor in Klasse Buch
public Buch(String titel, String autor, int jahr){
        super(45); // Das Argument passt zum Konstruktor der Elternklasse
        this.titel = titel;
        this.autor = autor;
        this.jahr = jahr;

}
````


***

### Funfact

Der Compiler ergänzt auch die Klassenbezeichnung, falls die Klasse nicht explizit von einer anderen Klasse
erben soll.

````java
// Das sieht bei jeder Klasse ohne expliziter Elternklasse automatisch so aus
public class Katalogartikel extends Object{
    
}
````