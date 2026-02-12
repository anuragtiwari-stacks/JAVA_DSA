package _14Sorting._1ALGORITHM;

public class _3SelectionSort
{

    public static void selectionSort(int[] arr)
    {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++)
        {
            int minIdx = i;

            for (int j = i + 1; j < n; j++)
            {
                if (arr[j] < arr[minIdx])
                {
                    minIdx = j;
                }
            }

            // Swap arr[minIdx] and arr[i]
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
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
        int[] arr = {7, 4, 10, 8, 3, 1};

        System.out.println("Original array:");
        printArray(arr);

        selectionSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}

/*
📌 Concept: Selection Sort
- Repeatedly find the minimum element and place it at the beginning.
- Selection sort is **in-place** and **not stable** by default.

🧠 Time Complexity:
- Best, Worst, Average: O(n^2)

📦 Space: O(1)
❌ Not Stable (relative order of equal elements may change)
*/
