package _20DynamicProgramming;

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
Input:
nums = [1,1,1,1,1]
target = 3

totalSum = 5
subsetSum = (5 + 3)/2 = 4


INITIAL TABLE

        0 1 2 3 4
      ----------------
0 ele | 0 0 0 0 0
1 ele | 0 0 0 0 0
2 ele | 0 0 0 0 0
3 ele | 0 0 0 0 0
4 ele | 0 0 0 0 0
5 ele | 0 0 0 0 0



After Base Case:
dp[0][0] = 1


        0 1 2 3 4
      ----------------
0 ele | 1 0 0 0 0
1 ele | 0 0 0 0 0
2 ele | 0 0 0 0 0
3 ele | 0 0 0 0 0
4 ele | 0 0 0 0 0
5 ele | 0 0 0 0 0



After i = 1   (using first 1)

        0 1 2 3 4
      ----------------
0 ele | 1 0 0 0 0
1 ele | 1 1 0 0 0
2 ele | 0 0 0 0 0
3 ele | 0 0 0 0 0
4 ele | 0 0 0 0 0
5 ele | 0 0 0 0 0



After i = 2   (using two 1s)

        0 1 2 3 4
      ----------------
0 ele | 1 0 0 0 0
1 ele | 1 1 0 0 0
2 ele | 1 2 1 0 0
3 ele | 0 0 0 0 0
4 ele | 0 0 0 0 0
5 ele | 0 0 0 0 0



After i = 3   (using three 1s)

        0 1 2 3 4
      ----------------
0 ele | 1 0 0 0 0
1 ele | 1 1 0 0 0
2 ele | 1 2 1 0 0
3 ele | 1 3 3 1 0
4 ele | 0 0 0 0 0
5 ele | 0 0 0 0 0



After i = 4   (using four 1s)

        0 1 2 3 4
      ----------------
0 ele | 1 0 0 0 0
1 ele | 1 1 0 0 0
2 ele | 1 2 1 0 0
3 ele | 1 3 3 1 0
4 ele | 1 4 6 4 1
5 ele | 0 0 0 0 0



FINAL TABLE (i = 5)

        0 1 2 3 4
      ----------------
0 ele | 1 0 0 0 0
1 ele | 1 1 0 0 0
2 ele | 1 2 1 0 0
3 ele | 1 3 3 1 0
4 ele | 1 4 6 4 1
5 ele | 1 5 10 10 5



Answer:
dp[5][4] = 5
*/