package _17DynamicProgramming;

// LeetCode 494 - Target Sum
public class _17TargetSum_Tabulation
{
    public static int findTargetSumWays(int[] nums, int target)
    {
        int totalSum = 0;
        for (int num : nums)
        {
            totalSum += num;
        }

        // Edge cases
        if (Math.abs(target) > totalSum || (totalSum + target) % 2 != 0)
        {
            return 0;
        }

        int subsetSum = (totalSum + target) / 2;
        int n = nums.length;

        // dp[i][j] = number of ways using first i elements to make sum j
        int[][] dp = new int[n + 1][subsetSum + 1];

        // base case: sum = 0 → 1 way (pick nothing)
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++)
        {
            for (int j = 0; j <= subsetSum; j++)
            {
                // Option 1: skip
                dp[i][j] = dp[i - 1][j];

                // Option 2: pick
                if (nums[i - 1] <= j)
                {
                    dp[i][j] = dp[i][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][subsetSum];
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        System.out.println(findTargetSumWays(nums, target));
    }
}

/*
==================== TABULATION DRY RUN (STEP BY STEP) ====================

nums = [1, 1, 1, 1, 1]
target = 3

Total Sum S = 5
subsetSum = (S + target) / 2 = (5 + 3) / 2 = 4

dp[i][j] = number of ways using first i elements to make sum j

---------------------------------------------------------------------------
Initial DP (i = 0)

i\j | 0 | 1 | 2 | 3 | 4
-----------------------
0   | 1 | 0 | 0 | 0 | 0


---------------------------------------------------------------------------
After i = 1 (nums[0] = 1)

j=0:
skip → dp[0][0] = 1

j=1:
skip → dp[0][1] = 0
pick → dp[0][0] = 1
dp[1][1] = 1

i\j | 0 | 1 | 2 | 3 | 4
-----------------------
1   | 1 | 1 | 0 | 0 | 0


---------------------------------------------------------------------------
After i = 2 (nums[1] = 1)

j=1:
skip → dp[1][1] = 1
pick → dp[1][0] = 1
dp[2][1] = 2

j=2:
skip → dp[1][2] = 0
pick → dp[1][1] = 1
dp[2][2] = 1

i\j | 0 | 1 | 2 | 3 | 4
-----------------------
2   | 1 | 2 | 1 | 0 | 0


---------------------------------------------------------------------------
After i = 3 (nums[2] = 1)

j=1:
skip → 2
pick → dp[2][0] = 1
dp[3][1] = 3

j=2:
skip → 1
pick → dp[2][1] = 2
dp[3][2] = 3

j=3:
skip → 0
pick → dp[2][2] = 1
dp[3][3] = 1

i\j | 0 | 1 | 2 | 3 | 4
-----------------------
3   | 1 | 3 | 3 | 1 | 0


---------------------------------------------------------------------------
After i = 4 (nums[3] = 1)

j=1:
skip → 3
pick → dp[3][0] = 1
dp[4][1] = 4

j=2:
skip → 3
pick → dp[3][1] = 3
dp[4][2] = 6

j=3:
skip → 1
pick → dp[3][2] = 3
dp[4][3] = 4

j=4:
skip → 0
pick → dp[3][3] = 1
dp[4][4] = 1

i\j | 0 | 1 | 2 | 3 | 4
-----------------------
4   | 1 | 4 | 6 | 4 | 1


---------------------------------------------------------------------------
After i = 5 (nums[4] = 1)

j=1:
skip → 4
pick → dp[4][0] = 1
dp[5][1] = 5

j=2:
skip → 6
pick → dp[4][1] = 4
dp[5][2] = 10

j=3:
skip → 4
pick → dp[4][2] = 6
dp[5][3] = 10

j=4:
skip → 1
pick → dp[4][3] = 4
dp[5][4] = 5

i\j | 0 | 1 | 2 | 3 | 4
-----------------------
5   | 1 | 5 |10 |10 | 5


---------------------------------------------------------------------------
FINAL ANSWER:

dp[5][4] = 5

Meaning:
There are 5 ways to choose a subset with sum = 4
→ Hence 5 ways to assign + / - to reach target = 3

=====================================================================
*/
