package _20DynamicProgramming;

// LeetCode 213 - House Robber II
public class _5HouseRobberII
{
    public static int rob(int[] nums)
    {
        int n = nums.length;

        if (n == 0) return 0;
        if (n == 1) return nums[0];

        // Case 1: Pehla house include karo, last house exclude
        int case1 = robLinear(nums, 0, n - 2);

        // Case 2: Pehla house exclude karo, last house include
        int case2 = robLinear(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    private static int robLinear(int[] nums, int start, int end)
    {
        int n = end - start + 1;

        if (n == 1) return nums[start];

        int[] dp = new int[n];

        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < n; i++)
        {
            dp[i] = Math.max(dp[i - 1],
                             dp[i - 2] + nums[start + i]);
        }

        return dp[n - 1];
    }

    public static void main(String[] args)
    {
        int[] nums = {2, 3, 2};
        System.out.println(rob(nums));
    }
}

/*
==================== DRY RUN ====================

Input:
nums = [2, 3, 2]

Circular houses → first and last are adjacent

-----------------------
Case 1: Houses [0 ... n-2] → [2, 3]

dp[0] = 2
dp[1] = max(2, 3) = 3

Result = dp[n-1] = 3

-----------------------
Case 2: Houses [1 ... n-1] → [3, 2]

dp[0] = 3
dp[1] = max(3, 2) = 3

Result = dp[n-1] = 3

-----------------------
Final Answer:
max(3, 3) = 3
*/
