package _20DynamicProgramming;

public class _31LongestIncreasingSubsequence_Memoization
{
    static int n;

    static int[][] dp;

    public static int LIS(int[] nums)
    {
        n = nums.length;

        dp = new int[n][n];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                dp[i][j] = -1;
            }
        }

        return solve(nums, -1, 0);
    }

    public static int solve(int[] nums, int prevIdx, int currIdx)
    {
        if(currIdx == n)
        {
            return 0;
        }

        if(prevIdx != -1 && dp[prevIdx][currIdx] != -1)
        {
            return dp[prevIdx][currIdx];
        }

        int take = 0;

        if(prevIdx == -1 || nums[currIdx] > nums[prevIdx])
        {
            take = 1 + solve(nums, currIdx, currIdx + 1);
        }

        int skip = solve(nums, prevIdx, currIdx + 1);

        if(prevIdx != -1)
        {
            dp[prevIdx][currIdx] = Math.max(take, skip);
        }

        return Math.max(take, skip);
    }

    public static void main(String[] args)
    {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(LIS(nums));
    }
}