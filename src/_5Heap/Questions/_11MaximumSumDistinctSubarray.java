package _5Heap.Questions;

import java.util.ArrayList;
import java.util.HashSet;

public class _11MaximumSumDistinctSubarray
{
    public int maximumSubarraySum(int[] nums, int k)
    {
        int n = nums.length;

        if (n < k)
        {
            return 0;
        }

        int i = 0;
        int j = k - 1;
        int maxSum = 0;

        while (j < n)
        {
            int windowSum = calculateSum(nums, i, j);
            maxSum = Math.max(maxSum, windowSum);

            i++;
            j++;
        }

        return maxSum;
    }

    public int calculateSum(int[] nums, int i, int j)
    {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;

        // check window elements
        for (int x = i; x <= j; x++)
        {
            if (set.contains(nums[x]))
            {
                // duplicate found → invalid window
                return 0;
            }

            set.add(nums[x]);
            list.add(nums[x]);
            sum += nums[x];
        }

        return sum;
    }

    public static void main(String[] args)
    {
        _11MaximumSumDistinctSubarray obj =
                new _11MaximumSumDistinctSubarray();

        int[] nums = {3, 5, 3, 4};
        int k = 2;

        System.out.println(obj.maximumSubarraySum(nums, k)); // 8
    }
}
