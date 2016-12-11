package Übung4;

/**
 * Diese Klasse demonstriert die doppelt verkettete Liste.
 * Alle Testfälle sind hier zu finden.
 *
 * @author Stephan Dünkel, Leon Rösler, Ersin Yildirim
 */
public class Main {

    /**
     * Die Mainmethode testet alle Testfälle einer doppelt verketteten Liste.
     *
     * @param args Befehlszeilen Argument
     */
    public static void main(String[] args) {

        // initialisierung der LinkedList
        LinkedList<String> linkedList = new LinkedList<>();

        // add(T value) Test
        linkedList.add("0");
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("Hi");
        linkedList.add("Huhu");

        //indexOf(T value) Test
        // enthalten
        linkedList.indexOf("0");
        linkedList.indexOf("3");
        // nicht enthalten
        linkedList.indexOf("Hallo");

        // add(int index, T value) Test
        // linkedList.add(2, "4");

        //contains(T value) Test
        // enthalten
        linkedList.contains("0");
        linkedList.contains("2");
        // nicht enthalten
        linkedList.contains("Moin");

        //get(int index) Test
        linkedList.get(0);
        linkedList.get(3);

        // remove(T value) Test
        // enthalten
        linkedList.remove("Hi");
        linkedList.remove("Huhu");
        // nicht enthalten
        linkedList.remove("Halloeschen");

        // remove(int index) Test
        // linkedList.remove(1);

        // Ausgabe der Liste Test
        linkedList.writeListForward();

        // size Test
        linkedList.size();
    }
}