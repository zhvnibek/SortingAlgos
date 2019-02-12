package src;

class MergeSort {

    private void sort(int arr[]){

    }

    /* A utility function to print array of size n*/
    private static void printArray(int arr[]) {
        for (int anArr : arr) System.out.print(anArr + " ");
    }

    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6};

        MergeSort ob = new MergeSort();
        ob.sort(arr);
        printArray(arr);
    }
}
