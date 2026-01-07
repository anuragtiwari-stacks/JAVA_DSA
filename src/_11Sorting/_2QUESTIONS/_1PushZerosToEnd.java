package _11Sorting._2QUESTIONS;

public class _1PushZerosToEnd
{

    public static void pushZerosToEnd(int[] arr)
    {
        int n = arr.length;
        int pos = 0; // Position to place the next non-zero element

        // Move non-zero elements to the front
        for (int i = 0; i < n; i++)
        {
            if (arr[i] != 0)
            {
                arr[pos] = arr[i];
                pos++;
            }
        }

        // Fill the rest of the array with zeros
        while (pos < n)
        {
            arr[pos] = 0;
            pos++;
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {0, 1, 0, 3, 12};
        pushZerosToEnd(arr);
        System.out.print("Modified array: ");
        for (int num : arr)
        {
            System.out.print(num + " ");
        }
    }
}
