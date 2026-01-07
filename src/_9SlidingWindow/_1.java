package _9SlidingWindow;

public class _1
{
    public static int maxSubarraySumBruteForce(int[] arr, int k)
    {
        if (arr == null || arr.length < k)
        {
            throw new IllegalArgumentException("Array length must be at least k");
        }

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= arr.length - k; i++)
        {
            int currentSum = 0;

            for (int j = i; j < i + k; j++)
            {
                currentSum += arr[j];
            }

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args)
    {
        int[] nums = { 2, 1, 5, 1, 3, 2 };
        int k = 3;

        int result = maxSubarraySumBruteForce(nums, k);

        System.out.println("Maximum sum of subarray of size " + k + " is: " + result);
    }

}
