package Übung4;

/**
 * Diese Klasse realisiert die doppelt verkettete Liste.
 *
 * @author Stephan Dünkel, Leon Rösler, Ersin Yildirim
 */
public class ListElem<T> {

    public T value;
    public int index;
    private ListElem<T> next, prev;

    /**
     *
     * @param value value eines Elements
     * @param next next Element
     * @param prev preview Element
     */
    public ListElem(T value, ListElem<T> next, ListElem<T> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    /**
     *
     * @param index index eines Elements
     * @param value value eines Elements
     */
    public ListElem(int index, T value) {
        this.index = index;
        this.value = value;
    }

    /**
     *
     * @param next setzt next eines Elements
     */
    public void setNext(ListElem<T> next) {
        this.next = next;
    }

    /**
     *
     * @param prev setzt preview eines Elements
     */
    public void setPrev(ListElem<T> prev) {
        this.prev = prev;
    }

    /**
     *
     * @param element setzt value eines Elements
     */
    public void setValue(T element) { value = element; }

    /**
     *
     * @return next Element
     */
    public ListElem<T> getNext() {
        return next;
    }

    /**
     *
     * @return preview Element
     */
    public ListElem<T> getPrev() {
        return prev;
    }

    /**
     *
     * @return value eines Elements
     */
    public T getValue() {
        return value;
    }

    /**
     *
     * @return index eines Elements
     */
    public int getIndex() {
        return index;
    }

}
