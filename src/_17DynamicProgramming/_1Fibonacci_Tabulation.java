package _17DynamicProgramming;

//Leetcode 509
public class _1Fibonacci_Tabulation
{
    // Method to find nth Fibonacci number using DP
    public static int fibonacci(int n)
    {
        // base cases
        if (n == 0)
        {
            return 0;
        }
        if (n == 1)
        {
            return 1;
        }

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        // build dp array
        for (int i = 2; i <= n; i++)
        {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args)
    {
        int n = 6;

        System.out.println("Fibonacci of " + n + " is: " + fibonacci(n));
    }
}

/*
==================== DRY RUN ====================

Input:
n = 6

Step 1:
dp[0] = 0
dp[1] = 1

Step 2:
i = 2
dp[2] = dp[1] + dp[0]
      = 1 + 0
      = 1

i = 3
dp[3] = dp[2] + dp[1]
      = 1 + 1
      = 2

i = 4
dp[4] = dp[3] + dp[2]
      = 2 + 1
      = 3

i = 5
dp[5] = dp[4] + dp[3]
      = 3 + 2
      = 5

i = 6
dp[6] = dp[5] + dp[4]
      = 5 + 3
      = 8

Final dp array:
[0, 1, 1, 2, 3, 5, 8]

Output:
Fibonacci of 6 is: 8
*/
