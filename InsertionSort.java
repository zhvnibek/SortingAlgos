
class InsertionSort
{
    /* A binary search based function to find the position
       where item should be inserted in a[low..high] */
    private int binarySearch(int a[], int item, int low, int high) {
        if (high <= low)
            return (item > a[low])? (low + 1) : low;

        int mid = (low + high)/2;

        if(item == a[mid])
            return mid+1;

        if(item > a[mid])
            return binarySearch(a, item, mid+1, high);
        return binarySearch(a, item, low, mid-1);
    }
    /* Binary insertion sort*/
    private void binaryInsertionSort(int arr[]) {
        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int j = i - 1;
            /* find location where key should be inserted */
            int loc = binarySearch(arr, key, 0, j);
            /* shift all the items on arr[loc...j]*/
            while (j >= loc) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
    /*Function to sort array using insertion sort*/
    private void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i-1; 
            /* Move elements of arr[0..i-1], that are greater than key,
               to one position ahead of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }

    /* A utility function to print array of size n*/
    private static void printArray(int arr[]) {
        for (int anArr : arr) System.out.print(anArr + " ");
    }

    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6};

        InsertionSort ob = new InsertionSort();
//        ob.insertionSort(arr);
        ob.binaryInsertionSort(arr);
        printArray(arr);
    }
}