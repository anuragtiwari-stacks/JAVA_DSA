package _11Sorting._2QUESTIONS;

public class _7InversionCountBruteForce
{

    /*
        ✅ What is Inversion Count?

        An inversion in an array is a pair of indices (i, j) such that:
            - i < j
            - arr[i] > arr[j]

        The inversion count represents how far the array is from being sorted.
        The more inversions → the more unsorted the array.

        Example:
            arr = {2, 4, 1, 3, 5}

            Inversions:
                (2,1), (4,1), (4,3)
                Total = 3

            arr = {5, 4, 3, 2, 1}
            All pairs are inverted → Total = 10 (5C2)
    */

    public static int countInversions(int[] arr)
    {
        int count = 0;

        for (int i = 0; i < arr.length - 1; i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[i] > arr[j])
                {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        int[] arr1 = {2, 4, 1, 3, 5};
        int[] arr2 = {5, 4, 3, 2, 1};

        System.out.println("Inversion count (arr1): " + countInversions(arr1)); // Output: 3
        System.out.println("Inversion count (arr2): " + countInversions(arr2)); // Output: 10
    }
}
