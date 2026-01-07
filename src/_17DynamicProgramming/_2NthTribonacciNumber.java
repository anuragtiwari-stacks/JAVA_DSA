package _17DynamicProgramming;

// LeetCode 1137 - N-th Tribonacci Number
public class _2NthTribonacciNumber
{
    public static int tribonacci(int n)
    {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++)
        {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }

    public static void main(String[] args)
    {
        int n = 4;
        System.out.println(tribonacci(n));
    }
}

/*
==================== DRY RUN ====================

Input:
n = 4

Base:
dp[0] = 0
dp[1] = 1
dp[2] = 1

i = 3
dp[3] = dp[2] + dp[1] + dp[0]
      = 1 + 1 + 0
      = 2

i = 4
dp[4] = dp[3] + dp[2] + dp[1]
      = 2 + 1 + 1
      = 4

Final dp array:
[0, 1, 1, 2, 4]

Output:
4
*/
