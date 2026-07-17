package OA.TCS;

/*
 * Question:
 *
 * Vijay, an industrialist, recently opened a fuel industry.
 * There are N categories of fuel.
 *
 * Each fuel category has:
 * 1. Price of the container.
 * 2. Volume contained in the container.
 *
 * Hari has K units of money.
 * He can purchase at most one container from each fuel category.
 *
 * Find the maximum total volume Hari can purchase without
 * exceeding his budget.
 *
 * This is a standard 0/1 Knapsack Problem.
 *
 * Example:
 *
 * N = 5
 * K = 105
 *
 * Price  = {10, 10, 40, 50, 90}
 * Volume = {10, 20, 20, 50, 150}
 *
 * Output:
 * 170
 *
 * Time Complexity : O(N × K)
 * Space Complexity: O(N × K)
 */

public class FuelIndustry
{
    public static int maximumVolume(int[] price, int[] volume, int money)
    {
        int n = price.length;

        // dp[i][j] =
        // Maximum volume using first i fuel categories
        // with budget j

        int[][] dp = new int[n + 1][money + 1];

        // First row = 0
        for(int j = 0; j <= money; j++)
        {
            dp[0][j] = 0;
        }

        // First column = 0
        for(int i = 0; i <= n; i++)
        {
            dp[i][0] = 0;
        }

        // Fill DP Table
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= money; j++)
            {
                // Do not take current fuel
                dp[i][j] = dp[i - 1][j];

                // Take current fuel if budget allows
                if(price[i - 1] <= j)
                {
                    dp[i][j] = Math.max(
                            dp[i][j],
                            volume[i - 1] + dp[i - 1][j - price[i - 1]]
                    );
                }
            }
        }

        return dp[n][money];
    }

    public static void main(String[] args)
    {
        // Predefined Input

        int N = 5;
        int K = 105;

        int[] price =
                {
                        10, 10, 40, 50, 90
                };

        int[] volume =
                {
                        10, 20, 20, 50, 150
                };

        System.out.println("Number of Fuel Categories : " + N);
        System.out.println("Available Money           : " + K);

        System.out.println();

        System.out.println("Maximum Volume : " + maximumVolume(price, volume, K));
    }
}