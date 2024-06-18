# Lösung
***

### Welche Zeile kann raus?
````java
public void fuegeHinzu(String schluessel, int zahl){

    ArrayList<Integer> l = hm.get(schluessel);
    if(l != null) {
        l.add(zahl);
        hm.put(schluessel, l);
    }
}
````

#### Erklärung zur Methode:
Die Methode ``fuegeHinzu`` fügt eine Zahl (zahl) zu einer Liste von Zahlen hinzu, die mit einem bestimmten Schlüssel
(schluessel) in einer TreeMap verknüpft ist. Wenn es bereits eine Liste zu diesem Schlüssel gibt, wird die Zahl dieser 
Liste hinzugefügt.

#### Die Zeile, die entfernt werden kann, ist:
```
hm.put(schluessel, l);
```

#### Grund:
Wenn eine Liste (ArrayList<Integer>) bereits existiert und die Zahl (zahl) hinzugefügt wird, ist diese Liste bereits 
in der TreeMap enthalten und wird direkt aktualisiert. Da ArrayList ein Referenztyp ist, wird die Liste in der TreeMap 
selbst aktualisiert ("Call by Reference"), wenn die Methode ``add`` aufgerufen wird. Es ist daher nicht notwendig, 
die aktualisierte Liste erneut mit ``put`` in die TreeMap einzufügen.

````java
public void fuegeHinzu(String schluessel, int zahl){
    ArrayList<Integer> l = hm.get(schluessel);
    if (l != null) {
        l.add(zahl);
    }
}
````

Diese Version hat die gleiche Funktionalität wie die ursprüngliche, aber ist effizienter, da der unnötige ``put``-Aufruf 
entfernt wurde.