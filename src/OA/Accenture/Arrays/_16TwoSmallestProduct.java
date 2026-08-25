package OA.Accenture.Arrays;

// Question: From the two smallest array elements whose sum stays within a limit, return their product

import java.util.Arrays;

public class _16TwoSmallestProduct
{
    public static void main(String[] args)
    {
        int[] arr = {5, 3, 2, 8, 1, 6};
        int limit = 6;

        System.out.println(findProduct(arr, limit));
    }

    static int findProduct(int[] arr, int limit)
    {
        Arrays.sort(arr);

        int first = arr[0];
        int second = arr[1];

        if(first + second <= limit)
        {
            return first * second;
        }

        return -1;
    }
}