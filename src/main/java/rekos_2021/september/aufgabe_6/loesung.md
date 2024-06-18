# Lösung
***

Hier geht es darum einfach einen Reader zu erzeugen, der die Voraussetzung erfüllt.

````java
@Before
public void setUp(){
    r = new StringReader("ababababccc");
}
````
* Wir benutzen hier einen `StringReader`, da dieser sehr einfach handzuhaben ist, um einzelne Zeichenketten zu überprüfen


* Dieser String hat bei 8 Zeichen nur 2 Unterschiedliche
  * Deswegen würde `false` rauskommen


* Dieser String hat bei 9 Zeichen 3 Unterschiedliche
  * Deswegen würde `true` rauskommen


**Das wars dann eigentlich auch** 😅