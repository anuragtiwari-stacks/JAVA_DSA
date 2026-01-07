package _17DynamicProgramming;

// LeetCode 416 - Partition Equal Subset Sum
public class _15PartitionEqualSubsetSum
{
    public static boolean canPartition(int[] nums)
    {
        int totalSum = 0;

        for (int num : nums)
        {
            totalSum += num;
        }

        // If total sum is odd, cannot partition
        if (totalSum % 2 != 0)
        {
            return false;
        }

        int target = totalSum / 2;
        int n = nums.length;

        // dp[i][j] = can we form sum j using first i elements
        boolean[][] dp = new boolean[n + 1][target + 1];

        // sum = 0 is always possible
        for (int i = 0; i <= n; i++)
        {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= target; j++)
            {
                // Option 1: skip current element
                dp[i][j] = dp[i - 1][j];

                // Option 2: pick current element (if allowed)
                if (nums[i - 1] <= j)
                {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }
}

/*
==================== DRY RUN ====================

nums = [1, 5, 11, 5]

Total Sum = 22
Target = 11

dp[i][j] = can we make sum j using first i elements

Base:
dp[i][0] = true (sum 0 always possible)

------------------------------------------------
i = 1 (num = 1)
Possible sums: 0, 1

------------------------------------------------
i = 2 (num = 5)
Possible sums: 0, 1, 5, 6

------------------------------------------------
i = 3 (num = 11)
Possible sums: 0, 1, 5, 6, 11

------------------------------------------------
i = 4 (num = 5)
Possible sums: 0, 1, 5, 6, 10, 11

dp[4][11] = true

Final Answer:
true

Explanation:
Subset 1 = {11}
Subset 2 = {1, 5, 5}
Both sums = 11
*/
