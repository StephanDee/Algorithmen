package Übung4;

/**
 * Diese Klasse realisiert die doppelt verkettete Liste.
 *
 * @author Stephan D, Leon R, Ersin Y
 */
public class ListElem<T> {

    private T value;
    private int index;
    private String str;
    private ListElem<T> next, prev;

    public ListElem(String str) {
        this.str = str;
    }

    public ListElem(T value) {
        this.value = value;
    }

    public ListElem(int index, T value) {
        this.index = index;
        this.value = value;
    }

    public void setNext(ListElem<T> next) {
        this.next = next;
    }

    public void setPrev(ListElem<T> prev) {
        this.prev = prev;
    }

    public ListElem<T> getNext() {
        return this.next;
    }

    public ListElem<T> getPrev() {
        return this.prev;
    }

    public T getValue() {
        return value;
    }

}
