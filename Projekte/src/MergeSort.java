/**
 * Diese Klasse implementiert das MergeSort
 *
 * @author Stephan D, Leon R, Ersin Y
 * @version %I%, %G%
 */
public class MergeSort {

    /**
     * Diese Methode sortiert die Arrays nachdem Prinzip des MergeSort
     *
     * @param arr Das durchzugehende Array
     * @return int - Gibt das resultierende Ergebnis in int wieder
     */
    public static int[] ArrayMergeSort(final int[] arr) {

        // Bei nur einen Wert
        if (arr.length == 1) {
            return arr;
        }

        // Bei mehr als einen Wert

        return arr;
    }

    /**
     * Die Main-Methode von MergeSort
     *
     * @param args Befehlszeilen Argument
     */
    public static void main(String args[]) {

        // Test für mehrere Werte
        int[] arr1 = {5, 2, 4, 1, 3, 0, -1};

        // Test für einen Wert
        int[] arr2 = {1};
        int[] arr3 = ArrayMergeSort(arr2);
        for (int i : arr3) {
            System.out.println(i);
        }
    }
}
