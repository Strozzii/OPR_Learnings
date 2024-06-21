# Lösung
***

## Disclaimer
Die Klasse heisst bei mir [TokenizerTest](TokenizerTest.java), weil JUnit iwie faxen bei mir macht, wenn ich sie so nenne,
wie die Aufgabe will. Aber darauf kommts jetzt auch nicht an 😂

Hier kannst Du dir [ReaderTokenizer](ReaderTokenizer.java) anschauen, um eine komplette Implementierung dieser Klasse
anzuschauen.
***

## Grundgerüst

````java
class TokenizerTest {

    private Reader r;

    @BeforeEach
    void setUp() {
        r = new StringReader("Viel Erfolg bei OPR.");
    }
}
````
* Da wir über mehrere Testfälle hinaus, denselben Reader verwenden wollen, bietet sich hier der Reader als Instanzvariable an
* Mit ``@BeforeEach`` wird `setUp()` vor jedem Testfall aufgerufen
  * Hier wird lediglich ``r`` mit einem `StringReader` initialisiert immer mit dem gleichen String

***

## Testfälle

### Erster Testfall

````java
@Test
void testGibWoerter1() throws IOException {
    ReaderTokenizer rt = new ReaderTokenizer(r, ". ");
    HashSet<String> ist = (HashSet<String>) rt.gibWoerter();
    HashSet<String> soll = new HashSet<>();

    soll.add("Viel");
    soll.add("bei");
    soll.add("Erfolg");
    soll.add("OPR");

    assertEquals(soll, ist);
}
````
* Die Annotation ``@Test`` signalisiert JUnit, dass es sich um einen Testfall handelt
* Wir initialisieren den ``ReaderTokenizer`` mit dem `StringReader` und dem Trennzeichen für diesen Testfall (Punkt und Leerzeichen)
* Da ``rt.gibWoerter()`` ein ``Set<String>`` zurückgibt, müssen wir auch so ein ``Set`` als Soll-Ergebnis definieren
  * ``soll`` präparieren wir so, dass es dem gewünschten Ergebnis gleicht
  * Bei den Trennzeichen muss ``soll`` also jedes einzelne Wort einzelnd, ohne Punkt enthalten
* ``assertEquals`` prüft das Ist-Ergebnis mit dem Soll-Ergebnis auf Gleichheit
  * Erfolgreich ist der Test, wenn ``ist.equals(soll)`` ``true`` ist


### Zweiter Testfall

````java
@Test
void testGibWoerter2() throws IOException {
    ReaderTokenizer rt = new ReaderTokenizer(r, ".,!");
    HashSet<String> ist = (HashSet<String>) rt.gibWoerter();
    HashSet<String> soll = new HashSet<>();

    soll.add("Viel Erfolg bei OPR");

    assertEquals(soll, ist);
}
````
* Wie oben ``ReaderTokenizer`` und das `Set` als Soll-Ergebnis initialisieren
  * Diesmal aber sind die Trennzeichen anders (Punkt, Komma, Ausrufezeichen)
* Das Soll-Ergebnis soll diesmal den ganzen String als ein Element enthalten, **nur ohne Punkt**!
