/*
Given an array of integers arr and two integers k and threshold,
return the number of sub-arrays of size k and average greater than or equal to threshold.


Example 1:
Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
Output: 3
Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively.
All other sub-arrays of size 3 have averages less than 4 (the threshold).
*/
package _12SlidingWindow;

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

/*
DRY RUN

Input:
arr = [2,2,2,2,5,5,5,8]
k = 3
threshold = 4

Step 1:
targetSum = k * threshold
targetSum = 3 * 4 = 12

We need subarrays of size 3 whose sum >= 12

-------------------------------------------------

Initial Window (First k elements)

i = 0
j = 2

Window = [2,2,2]

windowSum = 2 + 2 + 2 = 6

Check:
6 >= 12 ? NO
count = 0

-------------------------------------------------

Slide Window

i = 1
j = 3

New windowSum = previousSum + arr[j] - arr[i-1]
windowSum = 6 + 2 - 2 = 6

Window = [2,2,2]

6 >= 12 ? NO
count = 0

-------------------------------------------------

i = 2
j = 4

windowSum = 6 + 5 - 2 = 9

Window = [2,2,5]

9 >= 12 ? NO
count = 0

-------------------------------------------------

i = 3
j = 5

windowSum = 9 + 5 - 2 = 12

Window = [2,5,5]

12 >= 12 ? YES
count = 1

-------------------------------------------------

i = 4
j = 6

windowSum = 12 + 5 - 2 = 15

Window = [5,5,5]

15 >= 12 ? YES
count = 2

-------------------------------------------------

i = 5
j = 7

windowSum = 15 + 8 - 5 = 18

Window = [5,5,8]

18 >= 12 ? YES
count = 3

-------------------------------------------------

j = 8 (Stop because j == n)

Final Answer:
count = 3

=================================================
*/