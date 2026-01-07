package _17DynamicProgramming;

// Subset Sum using Pure Recursion (No DP)
public class _14SubsetSum
{
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

        // option 1: skip current element
        boolean skip = subsetSum(arr, i + 1, target);

        // option 2: pick current element (if allowed)
        boolean pick = false;
        if (arr[i] <= target)
        {
            pick = subsetSum(arr, i + 1, target - arr[i]);
        }

        return skip || pick;
    }

    public static void main(String[] args)
    {
        int[] arr = {0, 8, 5, 2, 4};
        int target = 9;

        System.out.println(subsetSum(arr, 0, target));
    }
}

/*
==================== DRY RUN ====================

arr = [0, 8, 5, 2, 4]
target = 9

Call: subsetSum(0, 9)

i = 0, element = 0
skip → subsetSum(1, 9)
pick → subsetSum(1, 9)   (0 does not change target)

------------------------------------------------
i = 1, element = 8
skip → subsetSum(2, 9)
pick → subsetSum(2, 1)

------------------------------------------------
i = 2, element = 5
skip → subsetSum(3, 9)
pick → subsetSum(3, 4)

------------------------------------------------
i = 3, element = 2
skip → subsetSum(4, 9)
pick → subsetSum(4, 7)

------------------------------------------------
i = 4, element = 4
skip → subsetSum(5, 9) → false
pick → subsetSum(5, 5) → false

Return false

------------------------------------------------
Back to subsetSum(3, 4)
i = 3, element = 2
skip → subsetSum(4, 4)
pick → subsetSum(4, 2)

subsetSum(4, 4)
pick → subsetSum(5, 0) → true

Return true

------------------------------------------------
Backtracking continues...

Final Result:
true

Subset found:
5 + 4 = 9
*/
