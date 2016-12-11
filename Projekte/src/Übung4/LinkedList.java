package Übung4;

/**
 * Diese Klasse realisiert die Methoden des List Interface und die doppelt verkettete Liste.
 *
 * @author Stephan Dünkel, Leon Rösler, Ersin Yildirim
 */
public class LinkedList<T> implements List<T> {

    // Es ist das Erste Element in der Liste
    private ListElem<T> head = null;

    // Es ist das Letzte Element in der Liste
    private ListElem<T> tail = null;

    // Es gibt die Größe der Liste an
    private int size = 0;

    @Override
    public void add(T value) {

        // Wenn die Liste noch Leer ist erstelle neues Listenelement, setze preview, next = null und tail = head
        if (head == null) {
            head = new ListElem<>(value, null, null);
            tail = head;
        } else {
            // Ansonsten erstelle neues Listenelement am Ende der Liste,
            // setze next = null, preview = head, folgendes neues Listenelement = head
            head = new ListElem<>(value, null, head);
            head.getPrev().setNext(head);
        }
        // Weiteres Listenelement wurde eingefügt, zähle hoch
        size++;
    }

    @Override
    public void add(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        //TODO: Methode schreiben

        head = new ListElem<>(index, value);
        head.getPrev().setNext(head);
        head.getNext().setPrev(head);
        size++;
    }

    @Override
    public T contains(T value) {

        ListElem<T> elem;

        // Gehe alle Elemente durch
        for (elem = head; elem != null; elem = elem.getPrev()) {
            // Wenn der Wert eines Elements gefunden wurde, setze Verbindung zu vor und nachfolger
            if (elem.value == value) {
                System.out.println("contains: " + elem.getValue());
                return value;
            }
        }
        System.out.println("contains: Das Element \"" + value + "\" ist nicht enthalten.");
        return null;
    }

    @Override
    public int indexOf(T value) {

        ListElem<T> elem;
        int index = 0;

        // Gehe alle Elemente durch
        for (elem = tail; elem != null; elem = elem.getNext()) {
            // Wenn der Wert eines Elements gefunden wurde, setze Verbindung zu vor und nachfolger
            if (elem.value == value) {
                System.out.println("index: " + index);
                return index;
            } else {
                index++;
            }
        }
        // Wenn der Wert keines der Werte eines Listenelements übereinstimmt, gebe null zurück
        System.out.println("indexOf: \"" + value + "\" wurde nicht gefunden");
        return -1;
    }

    @Override
    public T remove(T value) {

        // Das zu löschende Element
        ListElem<T> elem;

        // Wenn der eingegebene Wert mit dem ersten Wert in Der Liste übereinstimmt
        if (value == head.getValue()) {
            // Wähle ausgewähltes Listenelement und trenne alle Verbindungen zum nächsten Element
            head = head.getPrev();
            head.getNext().setPrev(null);
            head.setNext(null);

            // Gefundenes Listenelement wurde gelöscht, zählt runter
            size--;
            return value;
        }
        if (value != head.getValue()) {
            // Ansonsten gehe alle Elemente durch
            for (elem = head; elem != null; elem = elem.getPrev()) {
                // Wenn der Wert eines Elements gefunden wurde, setze Verbindung zu vor und nachfolger
                if (elem.value == value) {
                    elem.getPrev().setNext(elem.getNext());
                    elem.getNext().setPrev(elem.getPrev());

                    // Gefundenes Listenelement wurde gelöscht, zählt runter
                    size--;
                    return value;
                }
            }
            // Wenn der Wert keines der Werte eines Listenelements übereinstimmt, gebe null zurück
            System.out.println("Das zu löschende Element: \"" + value + "\" wurde nicht gefunden.");
            return null;
        }
        return value;
    }

    @Override
    public T remove(int index) {

        //TODO: Methode schreiben, funktioniert noch nicht, was wird returnt?

        return null;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        ListElem<T> elem;

        // Gehe alle Elemente durch
        for (elem = tail; elem != null; elem = elem.getNext()) {
            // Wenn der Wert eines Elements gefunden wurde, setze Verbindung zu vor und nachfolger
            if (index == elem.index) {
                System.out.println("get: " + elem.getValue());
                return elem.getValue();
            } else {
                index--;
            }
        }
        // Wenn der Wert keines der Werte eines Listenelements übereinstimmt, gebe null zurück
        System.out.println("get: \"" + index + "\" wurde nicht gefunden");
        return null;
    }

    @Override
    public int size() {
        System.out.println("size: " + size);
        return size;
    }

    /**
     * Gibt die Liste Vorwärts wieder.
     */
    public void writeListForward() {
        System.out.println("Liste:");
        for (ListElem<T> elem = tail; elem != null; elem = elem.getNext()) {
            System.out.println(elem.getValue());
        }
    }
}
