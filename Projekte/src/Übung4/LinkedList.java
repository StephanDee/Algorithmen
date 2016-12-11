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

        // Wenn die Liste noch Leer ist erstelle ein neues Listenelement.
        if (head == null) {
            // Setze das vorrige Listenelement auf null, da kein vorriges Listenelement vorhanden ist.
            // Setze das nächste Listenelement auf null, da kein nächstes Listenelement vorhanden ist.
            // Setze tail gleich head, weil dieses Listenelement das Erste und das Letzte dieser Liste ist.
            head = new ListElem<>(value, null, null);
            tail = head;
        } else {
            // Ansonsten erstelle ein neues Listenelement am Ende der Liste.
            // Setze das nächste Listenelement auf null, da kein nächstes Listenelement vorhanden ist.
            // Setze eine Verbindung zum vorrigen Listenelement auf head.
            // Head holt sich das vor ihm in der Liste stehende Listenelement
            // und setzt eine Verbindung auf das nächste Listenelement, welches eingefügt wurde mit head fest.
            head = new ListElem<>(value, null, head);
            head.getPrev().setNext(head);
        }
        // Weiteres Listenelement wurde eingefügt, zähle hoch
        size++;
    }

    @Override
    public void add(int index, T value) {
        // Wenn der Index nicht kleiner 0 oder der Index größer, gleich der Länge der Liste ist
        if (index < 0 || index > size) {
            // Werfe die IndexOutOfBoundsException
            throw new IndexOutOfBoundsException("Der Index: \"" + index + "\" ist ausserhalb der Liste.");
        }

        //TODO: Value wird noch nicht in der writeListForward() angegeben

        ListElem<T> curElem = head;
        int indexCounter = 0;

        // This will be used to mark the node before the requested index node
        int targetIndex = index - 1;

        // This is the new node to be inserted in the list
        ListElem<T> newElem = new ListElem<>(value);

        if (curElem != null) {
            while (indexCounter < targetIndex && curElem.getNext() != null) {
                indexCounter++;
                curElem = curElem.getNext();
            }
            if (indexCounter == targetIndex) {
                newElem.setNext(curElem.getNext());
                curElem.setNext(newElem);
            } else if (index == 0) {
                newElem.setNext(head);
                head = newElem;
            }
        } else if (index == 0) {
            head = newElem;
        }
//        size++;
    }

    @Override
    public T contains(T value) {

        // Initialisiere ein Listenelement
        ListElem<T> elem;

        // Gehe alle Listenelemente der Liste Vorwärts durch
        for (elem = tail; elem != null; elem = elem.getNext()) {
            // Wenn der Wert eines Listenelements gefunden wurde, gebe den Wert aus
            if (elem.value == value) {
                System.out.println("contains: " + elem.getValue());
                return value;
            }
        }
        // Ansonsten gebe eine Fehlermeldung und null zurück
        System.out.println("contains: Das Element \"" + value + "\" ist nicht enthalten.");
        return null;
    }

    @Override
    public int indexOf(T value) {

        // Initialisiere ein Listenelement
        ListElem<T> elem;
        // Initialisiere eines Indexzähler
        int index = 0;

        // Gehe alle Listenelemente der Liste Vorwärts durch
        for (elem = tail; elem != null; elem = elem.getNext()) {
            // Wenn der Wert eines Elements gefunden wurde, gebe den Index aus
            if (elem.value == value) {
                System.out.println("indexOf: " + index);
                return index;
            } else {
                // Ansonsten zähle den Index hoch
                index++;
            }
        }
        // Wenn der Wert mit keinen Listenelement übereinstimmt, gebe eine Fehlermeldung und -1 zurück
        System.out.println("indexOf: \"" + value + "\" wurde nicht gefunden");
        return -1;
    }

    @Override
    public T remove(T value) {

        // Initialisiere Listenelement
        ListElem<T> elem;

        // Wenn der eingegebene Wert mit dem ersten Listenelement in der Liste übereinstimmt
        if (value == head.getValue()) {
            // Trennt alle Verbindungen zu diesem Listenelement
            // Navigiere zum nächsten Listenelement und trenne die Verbindung zum zu löschenden Listenelements.
            head = head.getPrev();
            head.getNext().setPrev(null);
            head.setNext(null);

            // Gefundenes Listenelement wurde gelöscht, zähle runter
            size--;

            return value;
        }
        // Wenn der eingegebene Wert nicht mit dem ersten Listenelement in der Liste übereinstimmt
        if (value != head.getValue()) {
            // Gehe alle Listenelemente Vorwärts durch
            for (elem = head; elem != null; elem = elem.getPrev()) {
                // Wenn der eingegebene Wert mit einen Listenelement übereinstimmt
                if (elem.value == value) {
                    // Setze eine Verbindung zu Vor und Nachfolger
                    elem.getPrev().setNext(elem.getNext());
                    elem.getNext().setPrev(elem.getPrev());

                    // Gefundenes Listenelement wurde gelöscht, zähle runter
                    size--;

                    return value;
                }
            }
        }
        // Wenn der Wert keines der Werte eines Listenelements übereinstimmt, gebe Fehlermeldung und null zurück
        System.out.println("remove: Das zu löschende Element: \"" + value + "\" wurde nicht gefunden.");
        return null;
    }

    @Override
    public T remove(int index) {

        //TODO: Methode schreiben
        return null;
    }

    @Override
    public T get(int index) {
        // Wenn der Index nicht kleiner 0 oder der Index größer, gleich der Länge der Liste ist
        if (index < 0 || index >= size) {
            // Werfe die IndexOutOfBoundsException
            throw new IndexOutOfBoundsException("Der Index: \"" + index + "\" ist ausserhalb der Liste.");
        }

        // Initialisiere Listenelement
        ListElem<T> elem;

        // Gehe alle Listenelemente Vorwärts durch
        for (elem = tail; elem != null; elem = elem.getNext()) {
            // Wenn der eingegebene Index mit den Index eines Listenelements übereinstimmt,
            // gebe den Wert des Listenelements wieder
            if (index == elem.index) {
                System.out.println("get: " + elem.getValue());
                return elem.getValue();
            } else {
                // Der eingegebene Index stimmt nicht mit dem Index
                // des ausgewählten Listenelements überein, zähle hoch
                index--;
            }
        }
        // Wenn der Index mit keinen der Indizes eines Listenelements übereinstimmt, gebe Fehlermeldung und null zurück
        System.out.println("get: \"" + index + "\" wurde nicht gefunden");
        return null;
    }

    @Override
    public int size() {
        // Gebe die aktuelle Länge der Liste wieder
        System.out.println("size: Die Anzahl der Elemente beträgt: " + size);
        return size;
    }

    /**
     * Es gibt die Listenelemente in der Liste Vorwärts wieder.
     */
    public void writeListForward() {
        System.out.println("Die Liste wird Vorwärts wiedergegeben:");
        // Gehe alle Listenelemente Vorwärts durch
        for (ListElem<T> elem = tail; elem != null; elem = elem.getNext()) {
            // Es gibt alle Werte in der Liste Vorwärts aus
            System.out.println(elem.getValue());
        }
    }
}