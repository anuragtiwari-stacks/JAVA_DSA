package _20DynamicProgramming;

// Leetcode 746
public class _3MinCostClimbingStairs
{
    public static int minCostClimbingStairs(int[] cost)
    {
        int n = cost.length;
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 0;

// Option 1: Step i-1 se aao
// Step i-1 tak pahunchne ka minimum cost = dp[i-1]
// Step i-1 se step i par jump karne ka cost = cost[i-1]
// Total cost = dp[i-1] + cost[i-1]

// Option 2: Step i-2 se aao
// Step i-2 tak pahunchne ka minimum cost = dp[i-2]
// Step i-2 se step i par jump karne ka cost = cost[i-2]
// Total cost = dp[i-2] + cost[i-2]

        for (int i = 2; i <= n; i++)
        {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1],
                             dp[i - 2] + cost[i - 2]);
        }

        return dp[n];
    }

    public static void main(String[] args)
    {
        int[] cost = {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost));
    }
}

/*
DRY RUN:

cost = [10, 15, 20]

dp[0] = 0
dp[1] = 0

i = 2
dp[2] = min(0 + 15, 0 + 10) = 10

i = 3
dp[3] = min(10 + 20, 0 + 15) = 15

Answer = 15
*/
