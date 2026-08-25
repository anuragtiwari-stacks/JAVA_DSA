package OA.Accenture.Arrays;

// Question: Find the maximum profit from buying and selling a stock

import java.util.Arrays;

public class _15BestTimeToBuyAndSellStock
{
    public static void main(String[] args)
    {
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(prices));
    }

    static int maxProfit(int[] prices)
    {
        int n = prices.length;

        int[] max = new int[n];

        max[n - 1] = prices[n - 1];

        for(int i = n - 2; i >= 0; i--)
        {
            max[i] = Math.max(max[i + 1], prices[i]);
        }

        int[] diff = new int[n];

        for(int i = 0; i < n; i++)
        {
            diff[i] = max[i] - prices[i];
        }

        Arrays.sort(diff);

        return diff[n - 1];
    }
}