package _17DynamicProgramming;

// LeetCode 322 - Coin Change (Tabulation, INF Pattern)
public class _25CoinChange_INF_Pattern
{
    public static int coinChange(int[] coins, int amount)
    {
        int n = coins.length;
        int INF = (int)1e9;

        // dp[i][j] = minimum coins to make amount j
        // using first i coins (unbounded)
        int[][] dp = new int[n + 1][amount + 1];

        // base case: 0 coins cannot make any positive amount
        for (int j = 1; j <= amount; j++)
        {
            dp[0][j] = INF;
        }

        // build dp table
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= amount; j++)
            {
                int skip = dp[i - 1][j];

                int take = INF;
                if (coins[i - 1] <= j)
                {
                    take = 1 + dp[i][j - coins[i - 1]];
                }

                dp[i][j] = Math.min(skip, take);
            }
        }

        if (dp[n][amount] >= INF)
        {
            return -1;
        }

        return dp[n][amount];
    }

    public static void main(String[] args)
    {
        int[] coins = {1, 2, 5};
        int amount = 11;

        System.out.println(coinChange(coins, amount));
    }
}

/*
==================== DRY RUN ====================

coins = [1, 2, 5]
amount = 11
INF = 1000000000

dp[i][j] = minimum coins to make amount j
           using first i coins

---------------- INITIAL STATE ----------------

After base initialization (i = 0):

        0   1   2   3   4   5   6   7   8   9  10  11
     ------------------------------------------------
0 |     0  INF INF INF INF INF INF INF INF INF INF INF
1 |     0   0   0   0   0   0   0   0   0   0   0   0
2 |     0   0   0   0   0   0   0   0   0   0   0   0
3 |     0   0   0   0   0   0   0   0   0   0   0   0

---------------- FINAL STATE ----------------

        0  1  2  3  4  5  6  7  8  9 10 11
     ------------------------------------
0 |     0 INF INF INF INF INF INF INF INF INF INF INF
1 |     0  1  2  3  4  5  6  7  8  9 10 11
2 |     0  1  1  2  2  3  3  4  4  5  5  6
3 |     0  1  1  2  2  1  2  2  3  3  2  3

FINAL ANSWER:
dp[3][11] = 3
(5 + 5 + 1)

===============================================
*/
