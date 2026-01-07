package _11Sorting._1ALGORITHM;

public class _2InsertionSort
{

    public static void insertionSort(int[] arr)
    {
        int size = arr.length;

        for (int i = 1; i < size; i++)
        {
            int temp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > temp)
            {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = temp;
        }
    }

    public static void printArray(int[] arr)
    {
        for (int value : arr)
        {
            System.out.print(value + " ");
        }

        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] arr = {5, 4, 10, 1, 6, 2};

        System.out.println("Unsorted array:");
        printArray(arr);

        insertionSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}

/*
📌 Concept: Insertion Sort
- Build the sorted part of the array step-by-step.
- For each index i from 1 to n-1:
    - Store arr[i] in a temp.
    - Compare it to the sorted part on the left (0 to i-1).
    - Shift elements larger than temp to the right.
    - Place temp in its correct position.

🧠 Time Complexity:
- Best: O(n) (when array is already sorted)
- Average/Worst: O(n^2)

📦 Space: O(1)
✅ Stable Sort
*/
