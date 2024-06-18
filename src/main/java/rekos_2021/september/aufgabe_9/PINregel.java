package rekos_2021.september.aufgabe_9;

@FunctionalInterface
public interface PINregel {
    boolean istZulaessig(String pin);
}
