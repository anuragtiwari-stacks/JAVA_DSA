package _17DynamicProgramming;

// LeetCode 70 - Climbing Stairs
public class _11ClimbingStairs
{
    public static int climbStairs(int n)
    {
        if (n == 0 || n == 1) return 1;

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++)
        {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args)
    {
        int n = 5;
        System.out.println(climbStairs(n));
    }
}

/*
==================== DRY RUN ====================

Input:
n = 5

Meaning:
dp[i] = i-th stair tak pahunchne ke total ways

Base:
dp[0] = 1
dp[1] = 1

i = 2
dp[2] = dp[1] + dp[0]
      = 1 + 1
      = 2

i = 3
dp[3] = dp[2] + dp[1]
      = 2 + 1
      = 3

i = 4
dp[4] = dp[3] + dp[2]
      = 3 + 2
      = 5

i = 5
dp[5] = dp[4] + dp[3]
      = 5 + 3
      = 8

Final dp array:
[1, 1, 2, 3, 5, 8]

Output:
8
*/
