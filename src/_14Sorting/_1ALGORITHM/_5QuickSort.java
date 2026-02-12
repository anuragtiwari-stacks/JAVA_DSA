package _14Sorting._1ALGORITHM;

public class _5QuickSort
{
    public static void main(String[] args)
    {
        int[] arr = {10, 7, 8, 9, 1, 5};

        System.out.println("Original array:");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array:");
        printArray(arr);
    }

    public static void quickSort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[low];
        int start = low;
        int end = high;

        while (start < end)
        {
            while (start < arr.length && arr[start] <= pivot)
            {
                start++;
            }

            while (arr[end] > pivot)
            {
                end--;
            }

            if (start < end)
            {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }

        int temp = arr[low];
        arr[low] = arr[end];
        arr[end] = temp;

        return end;
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
