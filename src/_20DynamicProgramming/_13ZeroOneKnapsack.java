package _20DynamicProgramming;

// 0/1 Knapsack using Pure Recursion

public class _13ZeroOneKnapsack
{
    public static int profit(int i, int[] wt, int[] val, int C)
    {
        // Base Case: No items left
        if (i == wt.length)
        {
            return 0;
        }

        // Option 1: Skip current item
        int skip = profit(i + 1, wt, val, C);

        // Option 2: Pick current item (if possible)
        int pick = 0;
        if (wt[i] <= C)
        {
            pick = val[i] + profit(i + 1, wt, val, C - wt[i]);
        }

        // Return maximum profit
        return Math.max(skip, pick);
    }

    public static void main(String[] args)
    {
        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int C = 7;

        System.out.println(profit(0, wt, val, C));
    }
}