package Übung4;

/**
 * @author Stephan Dünkel, Leon Rösler, Ersin Yildirim
 */
public class LinkedList<T> implements List<T> {

    // Es ist das Erste Element in der Liste
    private ListElem<T> head = null;
    // Es ist das Letzte Element in der Liste
    private ListElem<T> tail = null;
    // Es gibt die Größe der Liste an
    private static int size = 0;


    // Konstruktor ohne Übergabeparameter zum Erstellen einer neuen LinkedList
    //Am Angfang besteht eine Liste aus einem head-Element und einem tail-Element
    public LinkedList() {

        // der head bekommt als Nachfolger den tail, der Rest ist null
        this.head = new ListElem<T>(null, tail, null);
        // der tail bekommt als Vorgänger den head, der Rest ist null
        this.tail = new ListElem<T>(null, null, head);
    }


    /**
     * Ein neues Element wird am Ende der Liste hinzugefügt
     * Dafür wird eine Kopie des aktuell letzten Elements erstellt, um davon den Vorgänger zu bekommen
     *
     * @param value the value to be appended
     */
    @Override
    public void add(T value) {

        // Das Element vor dem tail holen
        ListElem<T> prevElem = tail.getPrev();
        // setze next = null, preview = head, folgendes neues Listenelement = head
        ListElem<T> newElem = new ListElem<T>(value, tail, prevElem);
        // Der tail bekommt als neuen Vorgänger das neue Element
        tail.setPrev(newElem);
        // Der alte Vorgönger bekommt als neuen Nachfolger das neue Element
        prevElem.setNext(newElem);

        //Die größe der Liste um eins erhöhen
        size++;
    }


    /**
     * Ein neues Element wird erstellt und an der spezifischen Stelle in der Liste eingefügt
     *
     * @param index - index at which the specified value has to be inserted
     * @param value - value to be inserted
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void add(int index, T value) {

        // Wenn der übergebene Index außerhalb der Liste liegt, wirf die IndexOutOfBoundsException
        if (index > (this.size - 1) || index < 0) throw new IndexOutOfBoundsException();

        // Zwei neue, erstmal leere, Elemente erstellen
        ListElem<T> prev;
        ListElem<T> newElem = new ListElem<T>(value, null, null);

        //Das Element an der Stelle des übergenbenen Indexes in der Liste suchen
        prev = getElementFromListohneMittelpunkt(index);

        // Den Vorgänger dieses Elements zum Vorgänger vom neuemElement
        newElem.setNext(prev.getNext());
        // Das neue Element bekommt als Vorgänger das vorher gesuchte Element
        newElem.setPrev(prev);
        // Das neue Element wird als Nachfolger des gesuchten Elements in der Liste gesetzt
        prev.setNext(newElem);

        //Die größe der Liste um eins erhöhen
        size++;
    }


    /**
     *
     * @param value - value whose presence in this list is to be tested
     * @return the value, if value is contained in this list;
     *          null, otherwise
     */
    @Override
    public T contains(T value) {

        // Initialisiere ein Listenelement zum Durchgehen
        ListElem<T> elem;

        // Gehe alle Listenelemente der Liste Vorwärts durch
        // --> Bis der Nachfolger des aktuellen Elements gleich null ist
        // Als Startpunkt wird der head festgelegt
        for (elem = head; elem != null; elem = elem.getNext()) {

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


    /**
     * Bekommt einen Value und sucht die Liste von Vorne nach Hinten ab, bis das Element gefunden wurde, das diesen Value besitzt und gibt den Index des Elements zurück
     * Ansonsten wird -1 zurückgegeben
     * @param value - value to search for
     * @return the index of first occurrence of specified value in this list,
     *          or -1, if this list does not contain the value
     */
    @Override
    public int indexOf(T value) {

        // Initialisiere ein Listenelement
        ListElem<T> elem;
        // Initialisiere eines Indexzähler am Index des head
        int index = -1;


        // Gehe alle Listenelemente der Liste Vorwärts durch
        for (elem = head; elem != null; elem = elem.getNext()) {

            // Wenn der Wert eines Elements gefunden wurde, gebe den Index aus
            if (elem.value == value) {

                System.out.println(value + " at indexOf: " + index);
                //1 abziehen, um head zu ignorieren
                return index-1;

            } else {
                // Ansonsten zähle den Index hoch
                index++;
            }
        }

        // Wenn der Wert mit keinen Listenelement übereinstimmt, gebe eine Fehlermeldung und -1 zurück
        System.out.println("indexOf: \"" + value + "\" wurde nicht gefunden");
        return -1;
    }


    /**
     * Liste wird mit einer Schleife durchlaufen, bei jedem Element wird überprüft, ob der Value
     * der gleiche, wie der übergebene ist.
     * Wenn das der fall ist, wird  das Element gelöscht
     * Wenn es kein Element mit diesem Value gibt, dann gibt die Methode null zurück
     *
     * @param value - the value to be removed from this list, if present
     * @return the removed value, it is contained in the list;
     *          otherwise: null
     */
    @Override
    public T remove(T value) {

        // Länge der Liste
        int liste = this.size();
        // Zählvariable zeigt den aktuellen Index
        int indexpointer = 0;

        // Das zu löschende Element
        ListElem<T> oldNextElem = head.getNext();
        // Das Element, das an die Stelle des gelöschten Elements wandert
        ListElem<T> newNextElem = oldNextElem.getNext();


        //solange
        while (indexpointer < liste) {

            // Wenn der Value des Element, gleich dem übergebenen Value ist oder wenn der Nachfolger des Heads nicht null ist
            if (oldNextElem.getValue().equals(value) && head.getNext() != null) {

                // Der Vorgänger vom zu löschhenden Element bekommt als Nachfolger den Nachfolger des zu löschenden Elements
                oldNextElem.getPrev().setNext(oldNextElem.getNext());
                // Der Vorgänger vom zu löschhenden Element bekommt als Vorgänger den Vorgänger des zu löschenden Elements
                oldNextElem.getNext().setPrev(oldNextElem.getPrev());
                // Liste wird um eins kürzer
                size--;
                // Value des zu löschenden Elementes
                return oldNextElem.getValue();
            } else {
                // Ansonsten: gehe zum nächsten Element und zähle den Pointer um eins hoch
                oldNextElem = oldNextElem.getNext();
                indexpointer++;
            }
        }

        return null;
    }


    /**
     * Ein Element in der Liste wird am übergebenen Index gelöscht
     * Dazu wird die Liste zunächst durchlaufen
     * Wenn der Index außerhalb der Größe der Liste liegt, wird null zurückgegeben und eine Exception geworfen
     * Ansonsten wird der Value von dem gelöschten Element zurückgegeben
     *
     * @param index - the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if index is out of range
     *                                   (<0 or >=size())
     */
    @Override
    public T remove(int index) {

        // Wenn der übergebene Index außerhalb der Liste liegt, wirf die IndexOutOfBoundsException
        if (index > (this.size - 1) || index < 0) throw new IndexOutOfBoundsException();

        // Initialisiere Listenelemente
        ListElem<T> elem;
        // Startpunkt beim head
        int pointer = -1;

        // Gehe alle Listenelemente Vorwärts durch
        for (elem = this.head;  elem != null; elem = elem.getNext()) {

            // Wenn der eingegebene Index mit Pointer übereinstimmt,
            // Ändere die Attirbute für den Vorgänger und Nachfolger, sodass sie aufeinander weisen
            if (index == pointer && elem.getValue() != null) {

                elem.getPrev().setNext(elem.getNext());
                elem.getNext().setPrev(elem.getPrev());

                // Value des gelöschten Elements wird zurückgegeben und Liste um eins verkürzt
                size--;
                return elem.getValue();

            } else {

                // Der eingegebene Index stimmt nicht mit dem Index
                // des ausgewählten Listenelements überein, zähle hoch
                pointer++;
            }
        }

        return elem.getValue();
    }


    /**
     *
     * Die Liste wird durchlaufen, um nach einem Element an der Indexstelle zu suchen
     * Wenn ein Element an der Stelle vorhanden ist, wird der Value des Element zurückgegeben
     * Ansonsten wird eine Exception gewirfen oder null mit einer entsprechenden Fehlermeldung zurückgegeben
     *
     * @param index - the index of the value to be returned
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if index is out of range
     *                                   (<0 or >=size())
     */
    @Override
    public T get(int index) {

        // Wenn der Index nicht kleiner 0 oder der Index größer, gleich der Länge der Liste ist, wird die IndexOutOfBoundsException geworfen
        if (index < 0 || index >= this.size -1) {

            throw new IndexOutOfBoundsException();
        }

        // Initialisiere Listenelement
        ListElem<T> elem;
        // Startpunkt beim head
        int pointer = -1;

        // Gehe alle Listenelemente Vorwärts durch
        for (elem = this.head;  elem != null; elem = elem.getNext()) {

            // Wenn der eingegebene Index mit Pointer übereinstimmt,
            // gebe den Wert des Listenelements wieder
            if (index == pointer) {

                System.out.println("Value: " + elem.getValue() + " at index " + index);
                return elem.getValue();

            } else {

                // Der eingegebene Index stimmt nicht mit dem Index
                // des ausgewählten Listenelements überein, zähle hoch
                pointer++;
            }
        }

        // Wenn der Index mit keinen der Indizes eines Listenelements übereinstimmt, gebe Fehlermeldung und null zurück
        System.out.println("There is no Value at index " + index);
        return null;
    }


    /**
     *
     * @return the size of the list
     */
    @Override
    public int size() {
        return this.size;
    }


    /**
     * Gibt die Values und Indize aller Elemente, die sich im Moment in der Liste befinden zurück
     */
    public void writeList() {
        int index = -1;
        for (ListElem<T> elem = head; elem != null; elem = elem.getNext()) {

            if (index < 0){
                System.out.println("HEAD");
                index++;
            }else if (index > this.size()-1){
                System.out.println("TAIL");
            }else {
                System.out.println("Index: " + index + "\t Value: " + elem.getValue());
                index++;
            }
        }
    }


    //Helpermethodes

    // Sucht den Index in der Liste und gibt das Element dazu zurück
    private ListElem<T> getElementFromListohneMittelpunkt(int index) {

        //Der Mittelpunkt wird auf die Hälfte der Länge der Liste gesetzt
        int midpoint = (this.size -1) / 2;

        // Ein neues Dummy-Element wird erstellt
        ListElem currentElem = new ListElem(null, null, null);

        //wenn der übergebende Index größer als null und kleiner als die Hälfte der ListenElemente ist
        // Dann liegt das Element in der ersten Hälfte der Liste, daher wird dort nach dem Element gesucht
        if (index < midpoint && index >= 0) {
            currentElem = getElementFromFirstHalf(index);

        // Ansonsten liegt das Element in der zweiten Hälfte, daher muss dort gesucht werden
        } else {
            currentElem = getElementFromSecondtHalf(index);
        }

        //Gibt das gesuchte Element an dem Übergebenen Index zurück
        return currentElem;
    }


    // Sucht ein Element in der vorderen Hälfte der Liste und gibt es zurück
    // Dafür wird die Liste von Vorne  bis zur Mitte durchlaufen
    public ListElem<T> getElementFromFirstHalf(int index) {

        // Die halbe Liste wird von Vorne nach Hinten bis zur Mitte durchgegangen, um nach dem ELement am Index zu suchen
        ListElem currentElem = this.head;
        for (int pointerIndex = 0; pointerIndex <= index; pointerIndex++) {

            // Wenn der Nachfolger des aktuellen Elements nicht null ist, wird das Element zum akutellen Element, von dem aus weiter gesucht wird
            if (currentElem.getNext() != null) {
            currentElem = currentElem.getNext();
            }
        }

        return currentElem;
    }


    //@TODO: Kommentieren
    // Sucht ein Element in der hinteren Hälfte der Liste und gibt es zurück
    // Dafür wird die Liste von hinten bis zur Mitte durchlaufen
    public ListElem<T> getElementFromSecondtHalf(int index) {

        // Die halbe Liste wird von Hinten nach Vorne bis zur Mitte durchgegangen, um nach dem ELement am Index zu suchen
        ListElem currentElem = this.tail;
        for (int pointerIndex = this.size - 1; pointerIndex >= index - 1; pointerIndex--) {

            // Wenn der Vorgänger des aktuellen Elements nicht null ist, wird das Element zum akutellen Element, von dem aus weiter gesucht wird
            if (currentElem.getPrev() != null) {
            currentElem = currentElem.getPrev();
            }
        }
        return currentElem;
    }

}
