package _17DynamicProgramming;

// LeetCode 198 - House Robber
public class _4HouseRobber
{
    public static int rob(int[] nums)
    {
        int n = nums.length;

        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++)
        {
            dp[i] = Math.max(dp[i - 1],
                             dp[i - 2] + nums[i]);
        }

        return dp[n - 1];
    }

    public static void main(String[] args)
    {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }
}

/*
==================== DRY RUN ====================

Input:
nums = [2, 7, 9, 3, 1]
n = 5

dp[0] = nums[0] = 2
dp[1] = max(nums[0], nums[1])
      = max(2, 7)
      = 7

i = 2
dp[2] = max(dp[1], dp[0] + nums[2])
      = max(7, 2 + 9)
      = 11

i = 3
dp[3] = max(dp[2], dp[1] + nums[3])
      = max(11, 7 + 3)
      = 11

i = 4
dp[4] = max(dp[3], dp[2] + nums[4])
      = max(11, 11 + 1)
      = 12

Final dp array:
[2, 7, 11, 11, 12]

Output:
12
*/
