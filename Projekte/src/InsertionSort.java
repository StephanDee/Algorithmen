/**
 * Created by Stephan D on 10.10.2016.
 */
public class InsertionSort {

    public static int[] ArrayInsertionSort(final int[] arr) {

        for (int j = 0; j < arr.length; j++) {

            // arr[0],...,arr[j] ist sortiert
            int key = arr[j];

            // sortiere key in arr[0],...,arr[j] ein
            int i = j - 1;

            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
            // arr[0],...,arr[j] ist sortiert
        }
        return arr;
    }

    public static void main(final String[] args) throws Exception {
        int[] arr1 = {1, 5, 4, 3, 2, -1, 0};
        int[] arr2 = ArrayInsertionSort(arr1);
        for (int i : arr2) {
            System.out.println(i);
        }
    }
}