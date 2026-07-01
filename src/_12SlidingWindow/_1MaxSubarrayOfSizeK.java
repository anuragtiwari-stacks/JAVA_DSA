package _12SlidingWindow;

import java.util.HashSet;

public class _1MaxSubarrayOfSizeK
{
    public static boolean isValid(int[] nums, int start, int end)
    {
        HashSet<Integer> set = new HashSet<>();

        for (int i = start; i <= end; i++)
        {
            if (set.contains(nums[i]))
            {
                return false;
            }

            set.add(nums[i]);
        }

        return true;
    }

    public static long getSum(int[] nums, int start, int end)
    {
        long sum = 0;

        for (int i = start; i <= end; i++)
        {
            sum = sum + nums[i];
        }

        return sum;
    }

    public static long maximumSubarraySum(int[] nums, int k)
    {
        int n = nums.length;

        int i = 0;
        int j = k - 1;

        long maxSum = 0;

        while (j < n)
        {
            if (isValid(nums, i, j))
            {
                long sum = getSum(nums, i, j);

                maxSum = Math.max(maxSum, sum);
            }

            i++;
            j++;
        }

        return maxSum;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 5, 4, 2, 9, 9, 9};

        int k = 3;

        System.out.println(maximumSubarraySum(nums, k));
    }
}