# Lösung
***

````java
public class B extends A{

    @Override
    public int n(int a){
        return 3 * a;
    }

}
````

***

````java
A a = new B();
````

Diese Zeile ist ein Indiz dafür, dass eine neue Klasse B erstellt werden muss, die eine
Unterklasse von A sein muss, weil das Objekt scheinbar in den Variablentypen A passen soll.

````java
System.out.println(a.m(10));
````

Da die Methode `m(10)` ausgeführt werden soll, diese aber nicht überschrieben werden kann
wegen des `final` muss `n()` überschrieben werden, da diese ja von `m()` aufgerufen wird.
