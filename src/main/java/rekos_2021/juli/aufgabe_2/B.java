package rekos_2021.juli.aufgabe_2;

public class B extends A {
    // (1) Durch "extends" erbt B von A --> B ist direkte Unterklasse von A

    /*
        (3) Jede Klasse ohne Konstruktor erhält vom Compiler einen Standardkonstruktor (siehe Unten)
        In jedem Konstrukor wird stets super() aufgerufen (ebenfalls nicht sichtbar), was den Konstruktor der
        Elternklasse aufruft. Da der Konstruktor von der Elternklasse ein Argument erwartet, führt super() zu einem
        Fehler, weil standardmäßig kein Argument übergeben wird durch super()
    */

    // Standardkonstruktor vom Compiler (den sieht man normalerweise nicht)
    /*
    public B(){
        super();
    }
    */


}
