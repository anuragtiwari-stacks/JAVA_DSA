package _11Sorting._1ALGORITHM;

public class _7CyclicSort_1
{

    public static void main(String[] args)
    {
        int[] arr = {3, 0, 1, 4, 2};

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
            if (arr[i] < arr.length && arr[i] != arr[arr[i]])
            {
                // Swap arr[i] with arr[arr[i]]
                int temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
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
