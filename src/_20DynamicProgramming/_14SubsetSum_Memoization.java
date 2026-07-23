package _20DynamicProgramming;

// Subset Sum using Memoization
public class _14SubsetSum_Memoization
{
    static Boolean[][] dp;

    public static boolean subsetSum(int[] arr, int i, int target)
    {
        // base case: target achieved
        if (target == 0)
        {
            return true;
        }

        // base case: array finished
        if (i == arr.length)
        {
            return false;
        }

        // already calculated
        if (dp[i][target] != null)
        {
            return dp[i][target];
        }

        // option 1: skip current element
        boolean skip = subsetSum(arr, i + 1, target);

        // option 2: pick current element (if allowed)
        boolean pick = false;

        if (arr[i] <= target)
        {
            pick = subsetSum(arr, i + 1, target - arr[i]);
        }

        // store answer in dp
        dp[i][target] = skip || pick;

        return dp[i][target];
    }

    public static void main(String[] args)
    {
        int[] arr = {8, 5, 3};
        int target = 11;

        dp = new Boolean[arr.length][target + 1];

        System.out.println(subsetSum(arr, 0, target));
    }
}