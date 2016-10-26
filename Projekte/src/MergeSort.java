import FileIntArrayMitBeispielen.FileIntArray;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Diese Klasse implementiert das MergeSort
 *
 * @author Stephan D, Leon R, Ersin Y
 */
public class MergeSort {

    /**
     * Diese Methode gibt das sortierte Array aus
     *
     * @param arrLeft Linkes Array
     */
    public static void mergeSort(final int[] arrLeft) {

        final int[] arrRight = new int[arrLeft.length];
        mergeSort(arrLeft, arrRight, 0, arrLeft.length - 1);
    }

    /**
     * Diese Methode zerlegt das Array, übergibt Arrays an Hilfsfunktionen und mischt diese wieder zusammen
     *
     * @param arrLeft  Linkes Array
     * @param arrRight Rechtes Array
     * @param left     int Wert vom linken Array
     * @param right    int Wert vom rechten Array
     */
    private static void mergeSort(final int[] arrLeft, final int[] arrRight, final int left, final int right) {

        // sortiert das Array in Indexgrenzen left bis right
        if (left < right) {
            final int middle = (left + right) / 2;              // Zerlegen
            mergeSort(arrLeft, arrRight, left, middle);         // Linke Hälfte sortieren
            mergeSort(arrLeft, arrRight, middle + 1, right);    // Rechte Hälfte sortieren
            merge(arrLeft, arrRight, left, middle + 1, right);  // zusammen mischen
        }
    }

    /**
     * Diese Methode vergleicht die Werte des linken Arrays mit dem rechten Array,
     * wenn der Wert im linken Array größer ist als das im rechten, tausche aus
     *
     * @param arrLeft  Linkes Array
     * @param arrRight Rechtes Array
     * @param left     int Wert vom linken Array
     * @param right    int Wert vom rechten Array
     * @param rightEnd Rechtes Ende
     */
    private static void merge(final int[] arrLeft, final int[] arrRight, int left, int right, int rightEnd) {

        // Linkes Ende
        final int leftEnd = right - 1;

        // Setzt den Wert an sortierter Stelle ein
        final int number = rightEnd - left + 1;

        // Zähler
        int count = left;

        // Weder arrLeft noch arrRight ist vollständig von links nach rechts durchlaufen
        while (left <= leftEnd && right <= rightEnd) {

            // Vergleicht ob der Wert im linken Array kleiner gleich dem Rechten Array ist
            if (arrLeft[left] <= arrLeft[right]) {
                arrRight[count++] = arrLeft[left++];
            } else {
                arrRight[count++] = arrLeft[right++];
            }

            // Kopiert den rest des linken Array
            while (left <= leftEnd) {
                arrRight[count++] = arrLeft[left++];
            }

            // Kopiert den rest des rechten Array
            while (right <= rightEnd) {
                arrRight[count++] = arrLeft[right++];
            }

            // Kopiert das rechte Array zurück
            for (int i = 0; i < number; i++, rightEnd--) {
                arrLeft[rightEnd] = arrRight[rightEnd];
            }
        }
    }

    /**
     * Die Main-Methode von MergeSort
     *
     * @param args Befehlszeilen Argument
     */
    public static void main(final String[] args) throws IOException {

        // FileIntArray.java Test
        final File file = new File("C:/Users/Stephan-PC/Repository/Algorithmen/Projekte/src/FileIntArrayMitBeispielen/Rand10_1");
        final int[] arr11 = FileIntArray.FileToIntArray(file.toString());
        mergeSort(arr11);
        System.out.println(arr11);

        // Standard Test
        final int[] arr1 = {6, 3, 4, 2, 1, -1, 5, 1, 0, 300, 123545, -200};
        mergeSort(arr1);
        System.out.println(Arrays.toString(arr1));

        // 0 Test
        final int[] arr2 = {0};
        mergeSort(arr2);
        System.out.println(Arrays.toString(arr2));


        // negativ Test
        final int[] arr3 = {-1, -23};
        mergeSort(arr3);
        System.out.println(Arrays.toString(arr3));


        // null Test
        final int[] arr4 = {};
        mergeSort(arr4);
        System.out.println(Arrays.toString(arr4));

        // umgekehrt Test
        final int[] arr5 = {5, 4, 3, 2, 1};
        mergeSort(arr5);
        System.out.println(Arrays.toString(arr5));
    }
}