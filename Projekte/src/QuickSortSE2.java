import java.util.Arrays;

/**
 * Created by Stephan D on 12.10.2016.
 *
 * Software Engeneering 2.
 * Sorts an array using the quicksort algorithm.
 */
public class QuickSortSE2 {

    public static int[] numbers;// The array to sort

    public static void sort(int[] values) {

        // check for empty or null array
        if (values == null || values.length == 0) {
            return;
        }

        numbers = values;
        quicksort(0, values.length - 1);
    }

    private static void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high - low) / 2];

        // Divide into two lists
        while (i <= j) {

            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }

            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            if (i <= j) {
                exchange(i, j);
                i++; // As we are done we can increase j
                j--;// .. and decrease j
            }
        }
        // Recursion
        if (low < j) quicksort(low, j);
        if (i < high) quicksort(i, high);
    }

    /**
     * Swaps two numbers.
     *
     * @param i One number
     * @param j Another number
     */
    // TODO: Is there a better way to do this?
    private static void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String args[]) throws Exception {
        int[] numbers = {3, 2, 1, 6, 5, 4};
        System.out.println(Arrays.toString(numbers));
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

}