package OA.Accenture.Arrays;

// Question: Find the maximum sum of a contiguous subarray (Kadane's Algorithm)

public class _9KadaneAlgorithm
{
    public static void main(String[] args)
    {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(maxSubArray(nums));
    }

    static int maxSubArray(int[] nums)
    {
        int currentSum = nums[0];
        int maxSum = nums[0];

        int n = nums.length;

        for(int i = 1; i < n; i++)
        {
            currentSum = Math.max(nums[i], nums[i] + currentSum);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}