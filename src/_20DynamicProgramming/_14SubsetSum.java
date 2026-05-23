package _20DynamicProgramming;

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
        int[] arr = {8,5,3};
        int target = 11;

        System.out.println(subsetSum(arr, 0, target));
    }
}

/*
==================== DRY RUN ====================
                           (0,11)
                         /         \
                    skip            pick8
                    /                 \
               (1,11)                (1,3)
               /    \                  |
          skip      pick5             skip
          /            \                |
      (2,11)          (2,6)           (2,3)
      /   \            /   \          /    \
   F       F        F      F       F      TRUE
*/
