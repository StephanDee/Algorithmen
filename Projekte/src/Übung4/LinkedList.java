package Übung4;

/**
 * Diese Klasse realisiert die Methoden des List Interface und die doppelt verkettete Liste.
 *
 * @author Stephan D, Leon R, Ersin Y
 */
public class LinkedList<T> implements List<T> {

    private ListElem<T> head, tail;
    private int size;

    public LinkedList() {
        head = new ListElem<>("Head");
        tail = new ListElem<>("Tail");
        head.setNext(tail);
        tail.setPrev(head);
        size = 0;
    }

    @Override
    public void add(T value) {
        ListElem<T> newElem = new ListElem<T>(value);
        ListElem<T> tailElem = getTail();
        tailElem.setNext(newElem);
        newElem.setPrev(tailElem);
        size++;
    }


    @Override
    public void add(int index, T value) {
        ListElem<T> newElem = new ListElem<T>(index, value);

        size++;
    }

    @Override
    public T contains(T value) {
        return null;
    }

    @Override
    public int indexOf(T value) {
        return 0;
    }

    @Override
    public T remove(T value) {
        size--;
        return null;
    }

    @Override
    public T remove(int index) {
        size--;
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int size() {
        return size;
        }

    public void writeList() {
        ListElem<T> le = head;
        while (le != null) {
            System.out.println(le.getValue());
            le = le.getNext();
        }
    }

    public ListElem<T> getHead() {
        return head;
    }

    public void setHead(ListElem<T> head) {
        this.head = head;
    }

    public ListElem<T> getTail() {
        ListElem<T> le = head;
        while (le.getNext() != null) {
            le = le.getNext();
        }
        return le;
    }

    public void setTail(ListElem<T> tail) {
        this.tail = tail;
    }
}
