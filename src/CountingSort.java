package src;

public class CountingSort {
    private static void sort(Integer[] array) {
        if (array.length == 0) {
            return;
        }

        // Determine minimum and maximum values
        Integer minValue = array[0];
        Integer maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            } else if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }

        sort(array, minValue, maxValue);
    }

    private static void sort(Integer[] array, int minValue, int maxValue) {
        int[] buckets = new int[maxValue - minValue + 1];

        for (Integer anArray : array) {
            buckets[anArray - minValue]++;
        }

        int sortedIndex = 0;
        for (int i = 0; i < buckets.length; i++) {
            while (buckets[i] > 0) {
                array[sortedIndex++] = i + minValue;
                buckets[i]--;
            }
        }
    }

    /* A utility function to print array of size n*/
    private static void printArray(Integer[] arr) {
        for (int anArr : arr) System.out.print(anArr + " ");
    }

    public static void main(String args[]) {
        Integer[] arr = {12, 11, 13, 5, 6, 5, 7,8,3,5, 41, 53};

        sort(arr);
        printArray(arr);
    }
}