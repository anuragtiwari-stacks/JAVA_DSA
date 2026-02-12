package _14Sorting._1ALGORITHM;

public class _4MergeSort
{

    public static void mergeSort(int[] arr, int left, int right)
    {
        if (left < right)
        {
            int mid = (left + right) / 2;

            // Sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right)
    {
        // Sizes of subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data
        for (int i = 0; i < n1; i++)
        {
            L[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++)
        {
            R[j] = arr[mid + 1 + j];
        }

        // Merge the temp arrays
        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void printArray(int[] arr)
    {
        for (int val : arr)
        {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Original array:");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}

/*
📌 Concept: Merge Sort
- Divide and Conquer algorithm.
- Recursively splits the array into halves and merges them in sorted order.

🧠 Time Complexity: O(n log n)
📦 Space Complexity: O(n)
✅ Stable Sort
*/

/*
Input: arr = {12, 11, 13, 5, 6, 7}
Call: mergeSort(arr, 0, 5)

Step-by-step Recursion:

1. mergeSort(0, 5)
   → mid = 2
   → mergeSort(0, 2)
       → mid = 1
       → mergeSort(0, 0) → return
       → mergeSort(1, 1) → return
       → merge(0, 0, 1)
         → Left = [12], Right = [11]
         → Result = [11, 12]
         → arr = {11, 12, 13, 5, 6, 7}
       → mergeSort(2, 2) → return
       → merge(0, 1, 2)
         → Left = [11, 12], Right = [13]
         → Result = [11, 12, 13]
         → arr = {11, 12, 13, 5, 6, 7}
   → mergeSort(3, 5)
       → mid = 4
       → mergeSort(3, 3) → return
       → mergeSort(4, 4) → return
       → merge(3, 3, 4)
         → Left = [5], Right = [6]
         → Result = [5, 6]
         → arr = {11, 12, 13, 5, 6, 7}
       → mergeSort(5, 5) → return
       → merge(3, 4, 5)
         → Left = [5, 6], Right = [7]
         → Result = [5, 6, 7]
         → arr = {11, 12, 13, 5, 6, 7}
   → merge(0, 2, 5)
     → Left = [11, 12, 13], Right = [5, 6, 7]
     → Result = [5, 6, 7, 11, 12, 13]
     → Final arr = {5, 6, 7, 11, 12, 13}

Final Sorted Array:
{5, 6, 7, 11, 12, 13}
*/
