/*
Given an array of integers arr and two integers k and threshold,
return the number of sub-arrays of size k and average greater than or equal to threshold.


Example 1:
Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
Output: 3
Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively.
All other sub-arrays of size 3 have averages less than 4 (the threshold).
*/
package _9SlidingWindow;

public class _2SubarraysWithAvgAboveThreshold
{

    public static int numOfSubarrays(int[] arr, int k, int threshold)
    {
        int count = 0;
        int windowSum = 0;
        int targetSum = k * threshold;
        int n = arr.length;

        int i = 0;
        int j = k - 1;

        // Calculate sum of first window
        for (int x = i; x <= j; x++)
        {
            windowSum = windowSum + arr[x];
        }

        if (windowSum >= targetSum)
        {
            count++;
        }

        i++;
        j++;

        // Slide the window using while loop
        while (j < n)
        {
            windowSum = windowSum + arr[j] - arr[i];

            if (windowSum >= targetSum)
            {
                count++;
            }

            i++;
            j++;
        }

        return count;
    }

    public static void main(String[] args)
    {
        int[] arr = { 2, 1, 3, 4, 1, 2, 1, 5, 3 };
        int k = 3;
        int threshold = 4;

        int result = numOfSubarrays(arr, k, threshold);

        System.out.println("Number of subarrays: " + result);
    }

}
