package src;

import java.util.Random;

public class QuickSort {
    private static <T extends Comparable<T>> void sort(T[] array) {
        System.out.println("Quicksort: ");
        sort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void sort(
            T[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);
            sort(array, left, pivot - 1);
            sort(array, pivot + 1, right);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        T pivot = array[right];
        int mid = left;
        for (int i = mid; i < right; i++) {
            if (array[i].compareTo(pivot) <= 0) {
                swap(array, i, mid++);
            }
        }
        swap(array, right, mid);
        return mid;
    }

    private static <T extends Comparable<T>> void swap(
            T[] array, int a, int b) {
        if (a != b) {
            T temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }
    }

    // Random pivot implementation below
    private static Random random = new Random();

    private static <T extends Comparable<T>> void randomSort(T[] array) {
        randomSort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void randomSort(
            T[] array, int left, int right) {
        if (left < right) {
            int pivot = randomPartition(array, left, right);
            randomSort(array, left, pivot - 1);
            randomSort(array, pivot + 1, right);
        }
    }

    private static <T extends Comparable<T>> int randomPartition(
            T[] array, int left, int right) {
        int pivot = left + random.nextInt(right - left);
        swap(array, right, pivot);
        return partition(array, left, right);
    }

    /* A utility function to print array of size n*/
    private static void printArray(Integer[] arr) {
        for (int anArr : arr) System.out.print(anArr + " ");
    }

    public static void main(String args[]) {
        Integer[] arr = {12, 11, 13, 5, 6, 5, 7,8,3,5, 41, 53};

//        sort(arr);
        randomSort(arr);
        printArray(arr);
    }
}