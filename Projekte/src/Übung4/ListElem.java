package Übung4;

/**
 * Diese Klasse realisiert die Listenelemente in der doppelt verketteten Liste.
 *
 * @author Stephan Dünkel, Leon Rösler, Ersin Yildirim
 */
public class ListElem<T> {

    public T value;
    public int index;
    private ListElem<T> next, prev;

    /**
     * Der Konstruktor zur Initialisierung eines Listenelements mit 3 Parametern.
     *
     * @param value Der Wert eines Listenelements
     * @param next  Die Verbindung zum nächsten Listenelement
     * @param prev  Die Verbindung zum vorrigen Listenelement
     */
    public ListElem(T value, ListElem<T> next, ListElem<T> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    /**
     * Der Konstruktor zur Initialisierung eines Listenelements mit 1 Parameter.
     *
     * @param value Der Wert eines Listenelements
     */
    public ListElem(T value) {
        this.value = value;
    }

    /**
     * Diese Methode setzt das nächste Listenelement fest.
     *
     * @param next Die Verbindung zum nächsten Listenelement
     */
    public void setNext(ListElem<T> next) {
        this.next = next;
    }

    /**
     * Diese Methode setzt das vorrige Listenelement fest.
     *
     * @param prev Die Verbindung zum vorrigen Listenelement
     */
    public void setPrev(ListElem<T> prev) {
        this.prev = prev;
    }

    /**
     * Diese Methode holt sich das nächste Listenelement.
     *
     * @return Es gibt das nächste Element wieder
     */
    public ListElem<T> getNext() {
        return next;
    }

    /**
     * Diese Methode holt sich das vorrige Listenelement.
     *
     * @return Es gibt das vorrige Element wieder
     */
    public ListElem<T> getPrev() {
        return prev;
    }

    /**
     * Diese Methode holt sich den Wert des Listenelements.
     *
     * @return Es gibt den Wert des Listenelements wieder
     */
    public T getValue() {
        return value;
    }

}