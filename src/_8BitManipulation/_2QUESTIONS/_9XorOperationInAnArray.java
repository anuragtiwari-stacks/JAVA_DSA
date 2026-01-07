package _8BitManipulation._2QUESTIONS;

public class _9XorOperationInAnArray
{

    public static int[] buildArray(int n, int start)
    {

        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
        {
            arr[i] = start + 2 * i;
        }

        return arr;
    }

    public static int xorArray(int[] arr)
    {

        int xor = 0;

        for (int val : arr)
        {
            xor = xor ^ val;
        }

        return xor;
    }

    public static void main(String[] args)
    {

        int n = 5;
        int start = 0;

        int[] arr = buildArray(n, start);
        int result = xorArray(arr);

        System.out.println(result);
    }

    /*
     Dry Run

     n = 5
     start = 0

     buildArray:
     i = 0 -> arr[0] = 0
     i = 1 -> arr[1] = 2
     i = 2 -> arr[2] = 4
     i = 3 -> arr[3] = 6
     i = 4 -> arr[4] = 8

     arr = [0, 2, 4, 6, 8]

     xorArray:
     xor = 0

     xor = 0 ^ 0 = 0
     xor = 0 ^ 2 = 2
     xor = 2 ^ 4 = 6
     xor = 6 ^ 6 = 0
     xor = 0 ^ 8 = 8

     Final Result = 8
    */
}
