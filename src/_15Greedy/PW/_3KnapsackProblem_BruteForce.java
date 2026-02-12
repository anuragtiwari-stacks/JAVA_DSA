/*
The code I just gave you does not deal with fractions — it’s a 0/1 greedy knapsack only
(items are either fully taken or not at all).

If you want fractional greedy, we just need to modify the picking loop so that:
If the next item’s weight doesn’t fully fit, we take only the fraction that fits.
Add that proportional profit, then stop.
*/
package _15Greedy.PW;

public class _3KnapsackProblem_BruteForce
{
    public static void main(String[] args)
    {
        int[] profit = {5, 10, 15, 7, 8, 9, 4};
        int[] weight = {1, 3, 5, 4, 1, 3, 2};
        int n = profit.length;
        int capacity = 15;

        double[] ratio = new double[n];
        for (int i = 0; i < n; i++)
        {
            ratio[i] = (double) profit[i] / weight[i];
        }

        // Bubble sort by ratio (descending)
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - i - 1; j++)
            {
                if (ratio[j] < ratio[j + 1])
                {
                    double tempR = ratio[j];
                    ratio[j] = ratio[j + 1];
                    ratio[j + 1] = tempR;

                    int tempP = profit[j];
                    profit[j] = profit[j + 1];
                    profit[j + 1] = tempP;

                    int tempW = weight[j];
                    weight[j] = weight[j + 1];
                    weight[j + 1] = tempW;
                }
            }
        }

        double totalProfit = 0;
        int totalWeight = 0;

        System.out.print("Items chosen: ");

        for (int i = 0; i < n; i++)
        {
            if (totalWeight + weight[i] <= capacity)
            {
                totalProfit += profit[i];
                totalWeight += weight[i];
                System.out.print("[P:" + profit[i] + ", W:" + weight[i] + "] ");
            }
            else
            {
                int remaining = capacity - totalWeight;
                double fractionProfit = profit[i] * ((double) remaining / weight[i]);
                totalProfit += fractionProfit;
                totalWeight += remaining;
                System.out.print("[P:" + fractionProfit + ", W:" + remaining + "] ");
                break;
            }
        }

        System.out.println("\nTotal Profit: " + totalProfit);
    }
}
