package _20DynamicProgramming;

// LeetCode 96 -> Unique Binary Search Trees
public class _40CatalanNumber
{
    public static int catalan(int n)
    {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++)
        {
            int sum = 0;

            for (int j = 1; j <= i; j++)
            {
                sum = sum + dp[j - 1] * dp[i - j];
            }

            dp[i] = sum;
        }

        return dp[n];
    }

    public static void main(String[] args)
    {
        int n = 5;

        System.out.println(catalan(n));
    }
}

/*
Catalan Number Series

1 1 2 5 14 42 ...


Formula:

dp[i] = dp[i] + dp[j - 1] * dp[i - j]

Applications:
1. Unique BST
2. Generate Parentheses
3. Binary Trees
4. Mountain-Valley Problems
*/