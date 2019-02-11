
public class HeapSort {
    private static <T extends Comparable<T>> void sort(T[] array) {
        int heapSize = array.length;
        buildHeap(array, heapSize);
        while (heapSize > 1) {
            swap(array, 0, heapSize - 1);
            heapSize--;
            heapify(array, heapSize, 0);
        }
    }

    private static <T extends Comparable<T>> void buildHeap(T[] array, int heapSize) {
        for (int i = (array.length / 2); i >= 0; i--) {
            heapify(array, heapSize, i);
        }
    }

    private static <T extends Comparable<T>> void heapify(
            T[] array, int heapSize, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest;
        if (left < heapSize && array[left].compareTo(array[i]) > 0)
            largest = left;
        else
            largest = i;
        if (right < heapSize && array[right].compareTo(array[largest]) > 0)
            largest = right;
        if (largest != i) {
            swap(array, i, largest);
            heapify(array, heapSize, largest);
        }
    }

    private static <T extends Comparable<T>> void swap(
            T[] array, int a, int b) {
        T temp = array[a];
        array[a] = array[b];
        array[b] = temp;
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
