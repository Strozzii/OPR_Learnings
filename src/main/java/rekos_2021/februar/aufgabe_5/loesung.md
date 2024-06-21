# Lösung
***
[Hier siehst Du den Code und siehst, dass es keinen Fehler gibt.](K.java)

## Aber warum ungünstig?

Dafür muss man verstehen wie ``hashCode()`` in Collection-Klassen, wie `HashSet` oder `HashMap`, verwendet wird.

![title](hashsetinsert.png)

Um die Effizienz beim Suchen von Werten zu erhöhen, existieren mehrere Buckets, die für einen speziellen Hashwert existieren.
In jedem dieser Buckets befinden sich die Daten, die dem Hashwert entsprechen. So können sich Daten statistisch gleichmäßig
über die verschiedenen Buckets verteilen.

Wenn man nun nach einem Wert sucht, überprüft man dessen Hash und sucht dann in dem entsprechenden Bucket. Dadurch müssen
nicht alle Werte der Datenstruktur überprüft werden.

Wenn allerdings (wie in der Aufgabe erklärt) alle Daten denselben Hashcode haben, befinden sich diese Daten alle im selben
Bucket. Was bedeutet, dass man im Worst Case alle Werte überprüfen muss um seinen gesuchten Wert zu finden.