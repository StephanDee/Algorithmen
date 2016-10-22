import java.util.Arrays;

/**
 * Diese Klasse implementiert das MergeSort
 *
 * @author Stephan D, Leon R, Ersin Y
 */
public class MergeSort {

    /**
     * Diese Methode sortiert die Arrays nachdem Prinzip des MergeSort
     *
     * @param arrLeft Das durchzugehende Array
     */
    public static void ArrayMergeSort(final int[] arrLeft) {
        final int[] arrRight = new int[arrLeft.length];
        mergeSort(arrLeft, arrRight, 0, arrLeft.length - 1);
    }

    /**
     *
     *
     * @param arrLeft
     * @param arrRight
     * @param left
     * @param right
     */
    private static void mergeSort(final int[] arrLeft, final int[] arrRight, final int left, final int right) {

        //
        if (left < right) {
            final int middle = (left + right) / 2;
            mergeSort(arrLeft, arrRight, left, middle);
            mergeSort(arrLeft, arrRight, middle + 1, right);
            merge(arrLeft, arrRight, left, middle + 1, right);
        }
    }

    /**
     *
     *
     * @param arrLeft
     * @param arrRight
     * @param left
     * @param right
     * @param rightEnd
     */
    private static void merge(final int[] arrLeft, final int[] arrRight, int left, int right, int rightEnd) {
        final int leftEnd = right - 1;
        final int number = rightEnd - left + 1;
        int count = left;

        //
        while (left <= leftEnd && right <= rightEnd)

            //
            if (arrLeft[left] <= arrLeft[right]) {
                arrRight[count++] = arrLeft[left++];
            } else {
                arrRight[count++] = arrLeft[right++];
            }

        // Kopiert den rest der linken Hälfte
        while (left <= leftEnd) {
            arrRight[count++] = arrLeft[left++];
        }

        // Kopiert den rest der rechten Hälfte
        while (right <= rightEnd) {
            arrRight[count++] = arrLeft[right++];
        }

        // Kopiert zurück in das arrRight
        for (int i = 0; i < number; i++, rightEnd--) {
            arrLeft[rightEnd] = arrRight[rightEnd];
        }
    }

    /**
     * Die Main-Methode von MergeSort
     *
     * @param args Befehlszeilen Argument
     */
    public static void main(final String args[]) {

        // Standard Test
        final int[] arr1 = {6, 3, 4, 2, 1, -1, 5, 1, 0, 300, -200, 123545};
        ArrayMergeSort(arr1);
        System.out.println(Arrays.toString(arr1));

        // 0 Test
        final int[] arr2 = {0};
        ArrayMergeSort(arr2);
        System.out.println(Arrays.toString(arr2));


        // negativ Test
        final int[] arr3 = {-1, -23};
        ArrayMergeSort(arr3);
        System.out.println(Arrays.toString(arr3));


        // null Test
        final int[] arr4 = {};
        ArrayMergeSort(arr4);
        System.out.println(Arrays.toString(arr4));

        // umgekehrt Test
        final int[] arr5 = {5, 4, 3, 2, 1};
        ArrayMergeSort(arr5);
        System.out.println(Arrays.toString(arr5));
    }
}