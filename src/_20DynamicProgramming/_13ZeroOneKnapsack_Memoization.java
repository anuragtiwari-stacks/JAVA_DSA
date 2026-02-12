package _20DynamicProgramming;

// 0/1 Knapsack using Recursion + Memoization
public class _13ZeroOneKnapsack_Memoization
{
    static int[][] dp;

    public static int profit(int i, int[] wt, int[] val, int C)
    {
        // Base case: no items left
        if (i == wt.length)
        {
            return 0;
        }

        // If already solved, return stored value
        if (dp[i][C] != -1)
        {
            return dp[i][C];
        }

        // Option 1: skip current item
        int skip = profit(i + 1, wt, val, C);

        // Option 2: pick current item (if possible)
        int pick = 0;
        if (wt[i] <= C)
        {
            pick = val[i] + profit(i + 1, wt, val, C - wt[i]);
        }

        // Store and return max of pick and skip
        dp[i][C] = Math.max(pick, skip);
        return dp[i][C];
    }

    public static void main(String[] args)
    {
        int[] wt  = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int C = 7;

        dp = new int[wt.length][C + 1];

        // Initialize dp with -1
        for (int i = 0; i < wt.length; i++)
        {
            for (int j = 0; j <= C; j++)
            {
                dp[i][j] = -1;
            }
        }

        System.out.println(profit(0, wt, val, C));
    }
}

/*
========================= FULL DRY RUN =========================

wt  = [1, 3, 4, 5]
val = [1, 4, 5, 7]
C   = 7

Meaning:
profit(i, C) = index i se end tak, capacity C me maximum profit

---------------------------------------------------------------
Call: profit(0, 7)

Item 0 (wt=1, val=1)
skip = profit(1, 7)
pick = 1 + profit(1, 6)

---------------------------------------------------------------
profit(1, 7)

Item 1 (wt=3, val=4)
skip = profit(2, 7)
pick = 4 + profit(2, 4)

---------------------------------------------------------------
profit(2, 7)

Item 2 (wt=4, val=5)
skip = profit(3, 7)
pick = 5 + profit(3, 3)

---------------------------------------------------------------
profit(3, 7)

Item 3 (wt=5, val=7)
skip = profit(4, 7) = 0
pick = 7 + profit(4, 2) = 7

dp[3][7] = max(7, 0) = 7

---------------------------------------------------------------
profit(3, 3)

wt[3] > 3 → cannot pick
skip = profit(4, 3) = 0

dp[3][3] = 0

---------------------------------------------------------------
Back to profit(2, 7)

skip = dp[3][7] = 7
pick = 5 + dp[3][3] = 5

dp[2][7] = 7

---------------------------------------------------------------
profit(2, 4)

Item 2 (wt=4, val=5)
skip = profit(3, 4)
pick = 5 + profit(3, 0)

profit(3, 4) → wt[3] > 4 → dp[3][4] = 0
profit(3, 0) → capacity 0 → dp[3][0] = 0

dp[2][4] = 5

---------------------------------------------------------------
Back to profit(1, 7)

skip = dp[2][7] = 7
pick = 4 + dp[2][4] = 9

dp[1][7] = 9

---------------------------------------------------------------
profit(1, 6)

Item 1 (wt=3, val=4)
skip = profit(2, 6)
pick = 4 + profit(2, 3)

---------------------------------------------------------------
profit(2, 6)

Item 2 (wt=4, val=5)
skip = profit(3, 6)
pick = 5 + profit(3, 2)

profit(3, 6):
skip = profit(4, 6) = 0
pick = 7 + profit(4, 1) = 7
dp[3][6] = 7

profit(3, 2):
wt[3] > 2 → dp[3][2] = 0

dp[2][6] = max(7, 5) = 7

---------------------------------------------------------------
profit(2, 3)

wt[2] > 3 → dp[2][3] = dp[3][3] = 0

---------------------------------------------------------------
Back to profit(1, 6)

skip = dp[2][6] = 7
pick = 4 + dp[2][3] = 4

dp[1][6] = 7

---------------------------------------------------------------
Back to profit(0, 7)

skip = dp[1][7] = 9
pick = 1 + dp[1][6] = 8

dp[0][7] = 9

---------------------------------------------------------------
FINAL ANSWER:
Maximum Profit = 9

Items picked:
Weight 3 (value 4)
Weight 4 (value 5)
===============================================================
*/
