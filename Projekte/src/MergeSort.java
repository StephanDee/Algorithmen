import FileIntArrayMitBeispielen.FileIntArray;

import java.io.IOException;

import java.util.*;

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
    public static void mergeSort(final Comparable[] arrLeft) {
        final Comparable[] arrRight = new Comparable[arrLeft.length];
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
    private static void mergeSort(final Comparable[] arrLeft, final Comparable[] arrRight, final int left, final int right) {
        if (left < right) {
            final int center = (left + right) / 2;              // Zerlegen
            mergeSort(arrLeft, arrRight, left, center);         // Linke Hälfte sortieren
            mergeSort(arrLeft, arrRight, center + 1, right);    // Rechte Hälfte sortieren
            merge(arrLeft, arrRight, left, center + 1, right);  // zusammen mischen
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
    private static void merge(final Comparable[] arrLeft, final Comparable[] arrRight, int left, int right, int rightEnd) {

        final int leftEnd = right - 1;
        final int number = rightEnd - left + 1;

        // Zähler
        int count = left;

        // Weder arrLeft noch arrRight ist vollständig von links nach rechts durchlaufen
        while (left <= leftEnd && right <= rightEnd) {

            // Vergleicht ob der Wert im linken Array kleiner gleich dem Rechten Array ist
            if (arrLeft[left].compareTo(arrLeft[right]) <= 0) {
                arrRight[count++] = arrLeft[left++];
            } else {
                arrRight[count++] = arrLeft[right++];
            }
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

    /**
     * Die Main-Methode von MergeSort
     *
     * @param args Befehlszeilen Argument
     */
    public static void main(final String[] args) throws IOException {

        // FileIntArray.java Test
        final Integer[] arr11 = FileIntArray.FileToIntArray("C:/Users/Stephan-PC/Repository/Algorithmen/Projekte/src/FileIntArrayMitBeispielen/Rand10_1");
        mergeSort(arr11);
        System.out.println("\n" + Arrays.toString(arr11));

        // Standard Test
        final Integer[] arr1 = {500, 6, 3, 4, 2, 1, -1, 5, 1, 0, 300, 123545, -200};
        mergeSort(arr1);
        System.out.println("\n\n" + Arrays.toString(arr1));

        // 0 Test
        final Integer[] arr2 = {0};
        mergeSort(arr2);
        System.out.println(Arrays.toString(arr2));


        // negativ Test
        final Integer[] arr3 = {-1, -23};
        mergeSort(arr3);
        System.out.println(Arrays.toString(arr3));


        // null Test
        final Integer[] arr4 = {};
        mergeSort(arr4);
        System.out.println(Arrays.toString(arr4));

        // umgekehrt Test
        final Integer[] arr5 = {5, 4, 3, 2, 1};
        mergeSort(arr5);
        System.out.println(Arrays.toString(arr5));
    }
}