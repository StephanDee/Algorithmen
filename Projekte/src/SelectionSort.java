/**
 * Created by Stephan D on 14.10.2016.
 */
public class SelectionSort {

    public static int[] ArraySelectionSort(final int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int key = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[key]) {
                    key = j;
                }
            }
            int lowerNumber = arr[key];
            arr[key] = arr[i];
            arr[i] = lowerNumber;
        }
        return arr;
    }

    public static void main(final String[] args) throws Exception {
        int[] arr1 = {1, 5, 4, 3, 2, -1, 0};
        int[] arr2 = ArraySelectionSort(arr1);
        for (int i : arr2) {
            System.out.println(i);
        }
    }
}
