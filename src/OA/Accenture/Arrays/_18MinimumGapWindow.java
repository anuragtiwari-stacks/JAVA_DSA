package OA.Accenture.Arrays;

// Question: From a fixed-size window of a sorted array, minimize the gap between the window's max and min

import java.util.Arrays;

public class _18MinimumGapWindow
{
    public static void main(String[] args)
    {
        int[] arr = {10, 20, 30, 100, 101, 102, 103, 104};
        int k = 5;

        System.out.println(findMinimumGap(arr, k));
    }

    static int findMinimumGap(int[] arr, int k)
    {
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;

        for(int i = 0; i <= arr.length - k; i++)
        {
            int difference = arr[i + k - 1] - arr[i];

            min = Math.min(min, difference);
        }

        return min;
    }
}