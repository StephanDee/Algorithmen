/**
 * Created by Stephan D on 10.10.2016.
 */
public class SelectionSort {

    public static int[] ArraySort(final int[] arr) {

        for (int j = 1; j < arr.length; j++) {

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

        public static void main(String[] args){
            int[] arr1 = {1,5,4,3,2};
            int[] arr2 = ArraySort(arr1);
            for (int i:arr2){
                System.out.println(i);
            }
        }
    }