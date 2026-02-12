package _20DynamicProgramming;

// Subset Sum using Recursion + Memoization
public class _14SubsetSum_Memoization
{
    static int[][] dp;

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

        // already computed
        if (dp[i][target] != -1)
        {
            return dp[i][target] == 1;
        }

        // option 1: skip current element
        boolean skip = subsetSum(arr, i + 1, target);

        // option 2: pick current element (if allowed)
        boolean pick = false;
        if (arr[i] <= target)
        {
            pick = subsetSum(arr, i + 1, target - arr[i]);
        }

        // store result in dp
        dp[i][target] = (skip || pick) ? 1 : 0;
        return skip || pick;
    }

    public static void main(String[] args)
    {
        int[] arr = {0, 8, 5, 2, 4};
        int target = 9;

        dp = new int[arr.length][target + 1];

        // initialize dp with -1
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j <= target; j++)
            {
                dp[i][j] = -1;
            }
        }

        System.out.println(subsetSum(arr, 0, target));
    }
}

/*
==================== DRY RUN ====================

arr = [0, 8, 5, 2, 4]
target = 9

Meaning:
dp[i][target] =
-1 → not computed
 0 → false
 1 → true

------------------------------------------------
Call: subsetSum(0, 9)

i = 0 (element = 0)
skip → subsetSum(1, 9)
pick → subsetSum(1, 9)

------------------------------------------------
i = 1 (element = 8)
skip → subsetSum(2, 9)
pick → subsetSum(2, 1)

------------------------------------------------
i = 2 (element = 5)
skip → subsetSum(3, 9)
pick → subsetSum(3, 4)

------------------------------------------------
i = 3 (element = 2)
skip → subsetSum(4, 9)
pick → subsetSum(4, 7)

------------------------------------------------
i = 4 (element = 4)
skip → subsetSum(5, 9) → false
pick → subsetSum(5, 5) → false

dp[4][9] = 0

------------------------------------------------
subsetSum(4, 7)
skip → subsetSum(5, 7) → false
pick → subsetSum(5, 3) → false

dp[4][7] = 0

------------------------------------------------
Back to subsetSum(3, 4)
skip → subsetSum(4, 4)
pick → subsetSum(4, 2)

subsetSum(4, 4)
pick → subsetSum(5, 0) → true

dp[4][4] = 1
dp[3][4] = 1

------------------------------------------------
Backtracking continues...

Eventually:
dp[0][9] = 1

Final Answer:
true

Subset found:
5 + 4 = 9
*/
