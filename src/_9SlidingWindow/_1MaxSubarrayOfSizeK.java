package _9SlidingWindow;

public class _1MaxSubarrayOfSizeK
{

    public static int maxSubarraySum(int[] arr, int k)
    {
        if (arr == null || arr.length < k)
        {
            throw new IllegalArgumentException("Array length must be at least k");
        }

        int i = 0;
        int j = k - 1;
        int windowSum = 0;
        int n = arr.length;

        // Calculate sum of first window
        for (int x = i; x <= j; x++)
        {
            windowSum += arr[x];
        }

        int maxSum = windowSum;

        i++;
        j++;

        // Slide the window
        while (j < n)
        {
            windowSum = windowSum + arr[j] - arr[i];
            maxSum = Math.max(maxSum, windowSum);

            i++;
            j++;
        }

        return maxSum;
    }

    public static void main(String[] args)
    {
        int[] nums = { 2, 1, 5, 1, 3, 2 };
        int k = 3;

        int result = maxSubarraySum(nums, k);
        System.out.println("Maximum sum of subarray of size " + k + " is: " + result);
    }

}

/*
==================== DRY RUN ====================

Input:
arr = {2, 1, 5, 1, 3, 2}
k = 3

Initial:
n = 6
i = 0
j = 2
windowSum = 0

First Window Calculation:
x = 0 → windowSum = 2
x = 1 → windowSum = 3
x = 2 → windowSum = 8

First window = [2, 1, 5]
maxSum = 8

After increment:
i = 1
j = 3

While Loop:

Iteration 1:
i = 1, j = 3
windowSum = 8 + arr[3] - arr[1]
          = 8 + 1 - 1
          = 8
maxSum = max(8, 8) = 8
Window = [1, 5, 1]

Iteration 2:
i = 2, j = 4
windowSum = 8 + arr[4] - arr[2]
          = 8 + 3 - 5
          = 6
maxSum = max(8, 6) = 8
Window = [5, 1, 3]

Iteration 3:
i = 3, j = 5
windowSum = 6 + arr[5] - arr[3]
          = 6 + 2 - 1
          = 7
maxSum = max(8, 7) = 8
Window = [1, 3, 2]

Loop ends (j = 6)

Final Answer:
maxSum = 8

===============================================
*/
