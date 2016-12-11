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

        // java LinkedList
        // java.util.LinkedList<String> linkedList2 = new java.util.LinkedList<>();
        // linkedList2.add("hi");
        // linkedList2.remove(0);

        // eigene LinkedList
        Übung4.LinkedList<String> linkedList = new LinkedList<>();

        // add(T value) Test
        linkedList.add("0");
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("muh");
        linkedList.add("Crazy");

        //indexOf(T value) Test
        linkedList.indexOf("0");
        linkedList.indexOf("2");
        linkedList.indexOf("asdqwe");

        // add(int index, T value) Test
        // linkedList.add(2, "4");

        //contains(T value) Test
        linkedList.contains("0");
        linkedList.contains("1");
        linkedList.contains("Moin");

        //get(int index) Test
        linkedList.get(3);

        // remove(T value) Test
        linkedList.remove("muh");
        linkedList.remove("Crazy");
        linkedList.remove("pete");

        // remove(int index) Test
        linkedList.remove(1);

        // Ausgabe der Liste Test
        linkedList.writeListForward();

        // size Test
        //System.out.println("size: " + linkedList.size());
        linkedList.size();
    }
}