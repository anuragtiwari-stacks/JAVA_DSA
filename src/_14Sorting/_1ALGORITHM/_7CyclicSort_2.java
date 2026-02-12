package _14Sorting._1ALGORITHM;

public class _7CyclicSort_2
{

    public static void main(String[] args)
    {
        int[] arr = {3, 1, 5, 4, 2};

        System.out.println("Original array:");
        printArray(arr);

        cyclicSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    public static void cyclicSort(int[] arr)
    {
        int i = 0;

        while (i < arr.length)
        {
            int correctIndex = arr[i] - 1;

            if (arr[i] != arr[correctIndex])
            {
                // Swap arr[i] and arr[correctIndex]
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            }
            else
            {
                i++;
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
}
