package Übung3;

import Übung3.FileIntArrayMitBeispielen.FileIntArray;

import java.io.IOException;
import java.util.*;

/**
 * Diese Klasse realisiert das MergeSort.
 *
 * @author Stephan D, Leon R, Ersin Y
 */
public class MergeSort {

    /**
     * Diese Methode gibt das sortierte Array aus.
     *
     * @param arr Array
     */
    public static void mergeSort(final Comparable[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * Diese Methode zerlegt das Array, übergibt Arrays an Hilfsfunktionen und mischt diese wieder zusammen.
     *
     * @param arr   Array
     * @param left  int Wert links
     * @param right int Wert rechts
     */
    private static void mergeSort(final Comparable[] arr, final int left, final int right) {
        if (left < right) {
            final int center = (left + right) / 2;  // Zerlegen
            mergeSort(arr, left, center);           // Linke Hälfte sortieren
            mergeSort(arr, center + 1, right);      // Rechte Hälfte sortieren
            merge(arr, left, center + 1, right);    // zusammen mischen
        }
    }

    /**
     * Diese Methode vergleicht die Werte in arr,
     * und fügt den jeweils kleineren Wert in H ein.
     * Wenn alle Werte sortiert worden sind, kopiert
     * es H in arr zurück.
     *
     * @param arr      Array
     * @param left     int Wert links
     * @param right    int Wert rechts
     * @param rightEnd Rechtes Ende
     */
    private static void merge(final Comparable[] arr, int left, int right, int rightEnd) {

        // Initialisierung des Hilfsfelds
        final Comparable[] H = new Comparable[arr.length];

        final int leftEnd = right - 1;
        final int length = rightEnd - left + 1;

        // Zähler
        int count = left;

        // Solange nicht vollständig von links nach rechts durchlaufen
        while (left <= leftEnd && right <= rightEnd) {

            // Vergleicht ob der Wert links kleiner gleich dem rechts ist
            if (arr[left].compareTo(arr[right]) <= 0) {
                H[count++] = arr[left++];
            } else {
                H[count++] = arr[right++];
            }
        }

        // Kopiert den rest der linken Hälfte
        while (left <= leftEnd) {
            H[count++] = arr[left++];
        }

        // Kopiert den rest der rechten Hälfte
        while (right <= rightEnd) {
            H[count++] = arr[right++];
        }

        // Kopiert H zurück
        for (int i = 0; i < length; i++, rightEnd--) {
            arr[rightEnd] = H[rightEnd];
        }
    }

    /**
     * Die Main-Methode von MergeSort.
     * Es führt das MergeSortverfahren anhand von Beispielen durch.
     *
     * @param args Befehlszeilen Argument
     */
    public static void main(final String[] args) throws IOException {

        // Startzeitpunkt
        final long timeStart = System.currentTimeMillis();

        // Beispieldaten Test
        final Integer[] arr11 = FileIntArray.FileToIntArray("src/Übung3/FileIntArrayMitBeispielen/Rand1000_1");
        mergeSort(arr11);
        System.out.println("\n" + Arrays.toString(arr11));

        // Endzeitpunkt
        final long timeEnd = System.currentTimeMillis();

        // Ausgabe der Compilierungsdauer
        System.out.println("Zeitmessung: " + (timeEnd - timeStart) + " ms");

        // Ergebnisse:
        // Datei, Zeitmessungswert
        // Rand10_1, 16ms
        // Rand10_2, 15ms
        // Rand20_1, 16ms
        // Rand20_2, 16ms
        // Rand50_1, 16ms
        // Rand50_2, 15ms
        // Rand100_1, 16ms
        // Rand100_2, 15ms
        // Rand200_1, 16ms
        // Rand200_2, 15ms
        // Rand500_1, 31ms
        // Rand500_2, 31ms
        // Rand1000_1, 47ms
        // Rand1000_2, 62ms
        // Rand10000_1, 266ms
        // Rand10000_2, 281ms
        // Rand100000_1, 1521ms
        // Rand100000_2, 1453ms
        // Sort10_1, 16ms
        // Sort20_1, 15ms
        // Sort50_1, 15ms
        // Sort100_1, 16ms
        // Sort200_1, 16ms
        // Sort500_1, 31ms
        // Sort1000_1, 62ms
        // Sort10000_1, 172ms
        // Sort100000_1, 1438ms
    }
}