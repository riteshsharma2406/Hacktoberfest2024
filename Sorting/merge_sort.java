
import java.io.*;

class mergeSort {
  
    static void merge(int arr[], int left, int mid, int right)
    {
        // size of two subarray
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // temp arrays for left and right parts
        int Left[] = new int[n1];
        int Right[] = new int[n2];

        // copy elements to left and right arrays
        for (int i = 0; i < n1; ++i)
            Left[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            Right[j] = arr[mid + 1 + j];

        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < n1 && j < n2) {
            if (Left[i] <= Right[j]) {
                arr[k] = Left[i];
                i++;
            }
            else {
                arr[k] = Right[j];
                j++;
            }
            k++;
        }

        // copy remaning element of Left[] array
        while (i < n1) {
            arr[k] = Left[i];
            i++;
            k++;
        }

        // Copy remaining elements of Right[] array
        while (j < n2) {
            arr[k] = Right[j];
            j++;
            k++;
        }
    }

    // Main function
    static void sort(int arr[], int left, int right)
    {
        if (left < right) {

            // Find the middle point
            int mid = left + (right - left) / 2;

            // Sort first and second halves
            sort(arr, left, mid);
            sort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Print array of size n
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given array is");
        printArray(arr);

        sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array is");
        printArray(arr);
    }
}
