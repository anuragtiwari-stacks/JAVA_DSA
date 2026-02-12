package _20DynamicProgramming;

// LeetCode 518. Coin Change II

public class _34CoinChangeII
{
    public static int change(int amount, int[] coins)
    {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for(int i = 0; i <= n; i++)
        {
            dp[i][0] = 1;
        }

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= amount; j++)
            {
                int skip = dp[i - 1][j];
                int take = 0;
                if(coins[i - 1] <= j)
                {
                    take = dp[i][j - coins[i - 1]];
                }
                dp[i][j] = skip + take;
            }
        }

        return dp[n][amount];
    }

    public static void main(String[] args)
    {
        int[] coins = {1, 2, 5};
        int amount = 5;
        int ways = change(amount, coins);
        System.out.println("Number of ways = " + ways);
    }
}

/*
===================== DRY RUN =====================

coins = [1,2,5], amount = 5
n = 3

dp size = (4 x 6)

Initialization:
dp[i][0] = 1 for all i
dp[0][j] = 0 for j>0

Initial dp table:
       0 1 2 3 4 5
     ----------------
dp0 |  1 0 0 0 0 0
dp1 |  1 0 0 0 0 0
dp2 |  1 0 0 0 0 0
dp3 |  1 0 0 0 0 0

------------------------------------
i = 1 (coin = 1)

j=1: skip=0, take=dp[1][0]=1 → dp[1][1]=1
j=2: skip=0, take=dp[1][1]=1 → dp[1][2]=1
j=3: skip=0, take=dp[1][2]=1 → dp[1][3]=1
j=4: skip=0, take=dp[1][3]=1 → dp[1][4]=1
j=5: skip=0, take=dp[1][4]=1 → dp[1][5]=1

dp now:
       0 1 2 3 4 5
     ----------------
dp0 |  1 0 0 0 0 0
dp1 |  1 1 1 1 1 1
dp2 |  1 0 0 0 0 0
dp3 |  1 0 0 0 0 0

------------------------------------
i = 2 (coin = 2)

j=1: skip=1, take=0 → dp[2][1]=1
j=2: skip=1, take=dp[2][0]=1 → 1+1=2
j=3: skip=1, take=dp[2][1]=1 → 1+1=2
j=4: skip=1, take=dp[2][2]=2 → 1+2=3
j=5: skip=1, take=dp[2][3]=2 → 1+2=3

dp now:
       0 1 2 3 4 5
     ----------------
dp0 |  1 0 0 0 0 0
dp1 |  1 1 1 1 1 1
dp2 |  1 1 2 2 3 3
dp3 |  1 0 0 0 0 0

------------------------------------
i = 3 (coin = 5)

j=1: skip=1, take=0 → dp[3][1]=1
j=2: skip=2, take=0 → dp[3][2]=2
j=3: skip=2, take=0 → dp[3][3]=2
j=4: skip=3, take=0 → dp[3][4]=3
j=5: skip=3, take=dp[3][0]=1 → 3+1=4

dp now:
       0 1 2 3 4 5
     ----------------
dp0 |  1 0 0 0 0 0
dp1 |  1 1 1 1 1 1
dp2 |  1 1 2 2 3 3
dp3 |  1 1 2 2 3 4

================= FINAL DP TABLE =================

       0 1 2 3 4 5
     ----------------
dp0 |  1 0 0 0 0 0
dp1 |  1 1 1 1 1 1
dp2 |  1 1 2 2 3 3
dp3 |  1 1 2 2 3 4

Answer = dp[3][5] = 4

Number of ways = 4

==================================================
*/
