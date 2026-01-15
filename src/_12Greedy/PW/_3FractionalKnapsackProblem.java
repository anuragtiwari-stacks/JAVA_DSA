package _12Greedy.PW;

public class _3FractionalKnapsackProblem
{
    public static void main(String[] args)
    {
        int[] profit = {5, 10, 15, 7, 8, 9, 4};
        int[] weight = {1, 3, 5, 4, 1, 3, 2};
        int n = profit.length;
        int capacity = 15;

        boolean[] taken = new boolean[n];
        double totalProfit = 0;
        int totalWeight = 0;

        System.out.print("Items chosen (fractional greedy): ");

        while (totalWeight < capacity)
        {
            // Find item with highest ratio that is not taken
            double maxRatio = 0;
            int maxIndex = -1;
            for (int i = 0; i < n; i++)
            {
                if (!taken[i])
                {
                    double ratio = (double) profit[i] / weight[i];
                    if (ratio > maxRatio)
                    {
                        maxRatio = ratio;
                        maxIndex = i;
                    }
                }
            }

            // If no item left, break
            if (maxIndex == -1)
            {
                break;
            }

            taken[maxIndex] = true;

            if (totalWeight + weight[maxIndex] <= capacity)
            {
                totalProfit += profit[maxIndex];
                totalWeight += weight[maxIndex];
                System.out.print("[P:" + profit[maxIndex] + ", W:" + weight[maxIndex] + "] ");
            }
            else
            {
                int remaining = capacity - totalWeight;
                double fractionProfit = profit[maxIndex] * ((double) remaining / weight[maxIndex]);
                totalProfit += fractionProfit;
                totalWeight += remaining;
                System.out.print("[P:" + fractionProfit + ", W:" + remaining + "] ");
                break;
            }
        }

        System.out.println("\nTotal Profit: " + totalProfit);
    }
}
