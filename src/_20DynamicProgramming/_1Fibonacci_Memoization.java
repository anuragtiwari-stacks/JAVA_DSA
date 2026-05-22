package _20DynamicProgramming;

//Leetcode 509
public class _1Fibonacci_Memoization
{
    public static int fibonacci(int n, int[] dp)
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

        // if already calculated
        if (dp[n] != -1)
        {
            return dp[n];
        }

        // recursive calls with memoization
        dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);
        return dp[n];
    }

    public static void main(String[] args)
    {
        int n = 6;

        int[] dp = new int[n + 1];

        // initialize dp array with -1
        for (int i = 0; i <= n; i++)
        {
            dp[i] = -1;
        }

        System.out.println("Fibonacci of " + n + " is: " + fibonacci(n, dp));
    }
}

/*
==================== DRY RUN ====================

Input:
n = 6

Initial dp array:
[-1, -1, -1, -1, -1, -1, -1]

Call: fibonacci(6)
→ fibonacci(5) + fibonacci(4)

fibonacci(5)
→ fibonacci(4) + fibonacci(3)

fibonacci(4)
→ fibonacci(3) + fibonacci(2)

fibonacci(3)
→ fibonacci(2) + fibonacci(1)

fibonacci(2)
→ fibonacci(1) + fibonacci(0)
→ 1 + 0 = 1
dp[2] = 1

fibonacci(3)
→ 1 + 1 = 2
dp[3] = 2

fibonacci(4)
→ 2 + 1 = 3
dp[4] = 3

fibonacci(5)
→ 3 + 2 = 5
dp[5] = 5

fibonacci(6)
→ 5 + 3 = 8
dp[6] = 8

Final dp array:
[-1, -1, 1, 2, 3, 5, 8]

Output:
Fibonacci of 6 is: 8
*/
