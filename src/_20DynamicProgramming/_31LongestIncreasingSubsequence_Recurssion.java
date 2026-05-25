package _20DynamicProgramming;

public class _31LongestIncreasingSubsequence_Recurssion
{
    public static int LIS(int[] nums)
    {
        return solve(nums, 0, Integer.MIN_VALUE);
    }

    public static int solve(int[] nums, int index, int prev)
    {
        if(index == nums.length)
        {
            return 0;
        }

        int skip = solve(nums, index + 1, prev);

        int take = 0;

        if(nums[index] > prev)
        {
            take = 1 + solve(nums, index + 1, nums[index]);
        }

        return Math.max(take, skip);
    }

    public static void main(String[] args)
    {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(LIS(nums));
    }
}