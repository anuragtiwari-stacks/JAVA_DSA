package _20DynamicProgramming;

// 0/1 Knapsack using Tabulation (Bottom-Up DP)

public class _13ZeroOneKnapsack_Tabulation
{
    public static int knapsack(int[] wt, int[] val, int C)
    {
        int n = wt.length;

        // dp[i][w] =
        // maximum profit using first i items with capacity w

        int[][] dp = new int[n + 1][C + 1];

        // First row = 0
        for(int w = 0; w <= C; w++)
        {
            dp[0][w] = 0;
        }

        // First column = 0
        for(int i = 0; i <= n; i++)
        {
            dp[i][0] = 0;
        }

        // Fill remaining table
        for(int i = 1; i <= n; i++)
        {
            for(int w = 1; w <= C; w++)
            {
                // Skip current item
                dp[i][w] = dp[i - 1][w];

                // Pick current item if possible
                if(wt[i - 1] <= w)
                {
                    dp[i][w] = Math.max(dp[i][w], val[i - 1] + dp[i - 1][w - wt[i - 1]]);
                }
            }
        }

        return dp[n][C];
    }

    public static void main(String[] args)
    {
        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};

        int C = 7;

        System.out.println(knapsack(wt, val, C));
    }
}