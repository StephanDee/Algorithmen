package Übung4;

/**
 * @author Stephan Dünkel, Leon Rösler, Ersin Yildirim
 */
public class Main {


    public static void main(String[] args) {


        // Neue LinkedList zum bearbeiten
        LinkedList<String> linkedList = new LinkedList<>();
        System.out.println("Neue leere Liste erstellt");
        System.out.println("__________________________________________________ \n");


        //@TODO: ChECK
        // add(T value) Test
        System.out.println("add(T value) Testen: ");
        linkedList.add("0");
        linkedList.add("1");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("muh");
        linkedList.add("Crazy");
        System.out.println( linkedList.size() + " Elemente eingefügt \n");
        System.out.println( "aktuelle Liste: ");
        linkedList.writeList();
        System.out.println("__________________________________________________ \n");


        //@TODO: CHECK
        // add(int index, T value) Test
        System.out.println("add(int index, T value) Testen: ");
        linkedList.add(2, "2");
        //linkedList.add(22, "22");

        System.out.println("Versucht Element '2' an Index 2 und Element '22' an Index 22 einzufügen... \n");
        System.out.println( "aktuelle Liste: ");
        linkedList.writeList();
        System.out.println("__________________________________________________ \n");


        //@TODO: CHECK
        //contains(T value) Test
        System.out.println("contains(T value) Testen: ");
        linkedList.contains("0");
        linkedList.contains("1");
        linkedList.contains("Moin");

        System.out.println("Überprüft, ob die obigen Elemente in der Liste vorhanden sind... \n");
        System.out.println( "aktuelle Liste: ");
        linkedList.writeList();
        System.out.println("__________________________________________________ \n");


        //@TODO: CHECK
        //get(int index) Test
        System.out.println("get(int index) Testen: ");
        linkedList.get(3);
        //linkedList.get(11);

        System.out.println("Element am Index 3 und 11 gesucht... \n");
        System.out.println( "aktuelle Liste: ");
        linkedList.writeList();
        System.out.println("__________________________________________________ \n");


        //@TODO: CHECK
        // remove(T value) Test
        System.out.println("remove(T value) Testen: ");
        linkedList.remove("2");
        linkedList.remove("pete");

        System.out.println("Versucht die Elemente mit Value '2' und 'pete' zu entfernen... \n");
        System.out.println( "aktuelle Liste: ");
        linkedList.writeList();
        System.out.println("__________________________________________________ \n");


        //@TODO: CHECK
        // remove(int index) Test
        System.out.println("remove(int index) Testen: ");
        linkedList.remove(2);
        //linkedList.remove(10);


        System.out.println("Versucht die Elemente an dem Index 2 und 10 zu entfernen... \n");
        System.out.println("aktuelle Liste: ");
        linkedList.writeList();
        System.out.println("__________________________________________________ \n");


        //Liste auffüllen
        System.out.println("Liste wieder auffüllen...");
        linkedList.add("11");
        linkedList.add("22");
        linkedList.add("33");
        System.out.println( "aktuelle Liste: ");
        linkedList.writeList();
        System.out.println("__________________________________________________ \n");


        //@TODO: CHECK
        //indexOf (T value) Test
        System.out.println("indexOf(T value) Testen: ");
        linkedList.indexOf("22");
        linkedList.indexOf("44");

        System.out.println("Versucht den Index der Elemente mit dem Value '22' und '44' zu bestimmmen... \n");
        System.out.println("aktuelle Liste: ");
        linkedList.writeList();
        System.out.println("__________________________________________________ \n");


        //@TODO: CHECK
        // size Test
        System.out.println("size()m Testen: ");
        System.out.println("size: " + linkedList.size() + "\n");

        System.out.println( "aktuelle Liste: ");
        linkedList.writeList();
        System.out.println("__________________________________________________ \n");
        System.out.println("__________________________________________________ \n");

    }

}
