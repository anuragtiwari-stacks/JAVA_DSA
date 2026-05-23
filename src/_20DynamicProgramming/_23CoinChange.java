package _20DynamicProgramming;

public class _23CoinChange
{
    static int INF = (int)1e9;

    public static int solve(int[] coins, int amount)
    {
        // Base Case
        if (amount == 0)
        {
            return 0;
        }

        if (amount < 0)
        {
            return INF;
        }

        int ans = INF;

        for (int coin : coins)
        {
            ans = Math.min(ans, 1 + solve(coins, amount - coin));
        }

        return ans;
    }

    public static void main(String[] args)
    {
        int[] coins = {1, 2, 5};
        int amount = 11;

        int ans = solve(coins, amount);

        if (ans >= INF)
        {
            System.out.println(-1);
        }
        else
        {
            System.out.println(ans);
        }
    }
}