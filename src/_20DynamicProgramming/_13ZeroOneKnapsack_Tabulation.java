package _20DynamicProgramming;

// 0/1 Knapsack using Tabulation (Bottom-Up DP)
public class _13ZeroOneKnapsack_Tabulation
{
    public static int knapsack(int[] wt, int[] val, int C)
    {
        int n = wt.length;

        // dp[i][w] = maximum profit using first i items with capacity w
        int[][] dp = new int[n + 1][C + 1];

        // Build dp table
        for (int i = 1; i <= n; i++)
        {
            for (int w = 0; w <= C; w++)
            {
                // Option 1: skip current item
                dp[i][w] = dp[i - 1][w];

                // Option 2: pick current item (if possible)
                if (wt[i - 1] <= w)
                {
                    dp[i][w] = Math.max(
                            dp[i][w],
                            val[i - 1] + dp[i - 1][w - wt[i - 1]]
                    );
                }
            }
        }

        return dp[n][C];
    }

    public static void main(String[] args)
    {
        int[] wt  = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int C = 7;

        System.out.println(knapsack(wt, val, C));
    }
}

/*
========================= FULL DRY RUN =========================

wt  = [1, 3, 4, 5]
val = [1, 4, 5, 7]
Capacity C = 7

Meaning:
dp[i][w] = max profit using first i items with capacity w

---------------------------------------------------------------
Initial dp table (i = 0):
All dp[0][w] = 0 (0 items → 0 profit)

---------------------------------------------------------------
i = 1 (item wt=1, val=1)

w=0 → dp[1][0] = 0
w=1 → max(dp[0][1], 1 + dp[0][0]) = 1
w=2..7 → 1

Row:
[0, 1, 1, 1, 1, 1, 1, 1]

---------------------------------------------------------------
i = 2 (item wt=3, val=4)

w=0 → 0
w=1 → 1
w=2 → 1
w=3 → max(1, 4 + 0) = 4
w=4 → max(1, 4 + 1) = 5
w=5 → 5
w=6 → 5
w=7 → 5

Row:
[0, 1, 1, 4, 5, 5, 5, 5]

---------------------------------------------------------------
i = 3 (item wt=4, val=5)

w=0 → 0
w=1 → 1
w=2 → 1
w=3 → 4
w=4 → max(5, 5 + 0) = 5
w=5 → max(5, 5 + 1) = 6
w=6 → max(5, 5 + 1) = 6
w=7 → max(5, 5 + 4) = 9

Row:
[0, 1, 1, 4, 5, 6, 6, 9]

---------------------------------------------------------------
i = 4 (item wt=5, val=7)

w=0 → 0
w=1 → 1
w=2 → 1
w=3 → 4
w=4 → 5
w=5 → max(6, 7 + 0) = 7
w=6 → max(6, 7 + 1) = 8
w=7 → max(9, 7 + 1) = 9

Row:
[0, 1, 1, 4, 5, 7, 8, 9]

---------------------------------------------------------------
FINAL ANSWER:
dp[4][7] = 9

Items chosen:
Weight 3 (value 4)
Weight 4 (value 5)
===============================================================
*/
