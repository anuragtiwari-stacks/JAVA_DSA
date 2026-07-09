package _20DynamicProgramming;

// LeetCode 494 - Target Sum (Memoization using 2D Array)

public class _17TargetSum_Memoization
{
    static int[][] dp;
    static int offset;

    public static int solve(int[] nums, int target, int i, int currSum)
    {
        // Base Case
        if (i == nums.length)
        {
            if (currSum == target)
            {
                return 1;
            }

            return 0;
        }

        // Already Computed
        if (dp[i][currSum + offset] != -1)
        {
            return dp[i][currSum + offset];
        }

        // + Sign
        int plus = solve(nums, target, i + 1, currSum + nums[i]);

        // - Sign
        int minus = solve(nums, target, i + 1, currSum - nums[i]);

        // Store Answer
        dp[i][currSum + offset] = plus + minus;

        return dp[i][currSum + offset];
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        // Calculate maximum possible sum
        int totalSum = 0;
        for (int num : nums)
        {
            totalSum += num;
        }

        // Offset for handling negative sums
        offset = totalSum;

        // DP Array
        dp = new int[nums.length][2 * totalSum + 1];

        // Initialize with -1
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = 0; j < 2 * totalSum + 1; j++)
            {
                dp[i][j] = -1;
            }
        }

        int ans = solve(nums, target, 0, 0);

        System.out.println(ans);
    }
}