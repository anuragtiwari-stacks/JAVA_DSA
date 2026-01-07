package _11Sorting._1ALGORITHM;

public class _1BubbleSort
{
    public static void bubbleSort(int[] arr)
    {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - 1 - i; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void printArray(int[] arr)
    {
        for (int num : arr)
        {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] arr = {5, 1, 4, 2, 8};

        System.out.println("Before Sorting:");
        printArray(arr);

        bubbleSort(arr);

        System.out.println("After Sorting:");
        printArray(arr);
    }
}

/*
🔍 Concept:
- Repeatedly step through the array
- Compare adjacent elements and swap if they are in wrong order
- With each pass, the largest unsorted element "bubbles up" to the end

🧠 Time Complexity:
- Best: O(n) when already sorted
- Worst: O(n^2)

📦 Space Complexity: O(1)
*/
