# Lösung
***
## Disclaimer

Auch hier gibt es eine Abweichung zur Aufgabe.

Aufgrund der Java-Version ist [dieser Test](StringTest.java) nicht zuverlässig, da die Error-Message für diese Exception
nicht immer gleich ist. Aber gemäß der Aufgabe ist das richtig, wenn man den Text entsprechend abändert.
***

````java
@Test
void test() {
    try {
        char c = "Haus".charAt(4);
    }
    catch (StringIndexOutOfBoundsException e) {
        assertEquals("String index out of range: 4", e.getMessage());
    }
}
````

* Da wir uns mit einer Exception beschäftigen wollen, ist ein ``try-catch`` sehr nice
  * Im ``try-Block`` erzwingen wir eine Exception mit der Anweisung aus der Ausgabe
  * Der ``catch-Block`` fängt die entsprechende Exception ab und benennen diese ``e`` um, damit arbeiten zu können
* Um auf die Meldung zuzugreifen, stellt die Klasse ``Exception`` die Methode `getMessage()` zur Verfügung
  * Diese testen wir auf Gleichheit mit dem Text aus der Aufgabe und schauen ob der Test durchkommt oder nicht


