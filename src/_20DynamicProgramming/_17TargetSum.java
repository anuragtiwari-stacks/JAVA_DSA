package _20DynamicProgramming;

// LeetCode 494 - Target Sum (Recursion Only)
public class _17TargetSum
{
    public static int solve(int[] nums, int target, int i, int currSum)
    {
        // base case: all elements used
        if (i == nums.length)
        {
            if (currSum == target)
            {
                return 1; // one valid way
            }
            else
            {
                return 0;
            }
        }

        // choose + sign
        int plus = solve(nums, target, i + 1, currSum + nums[i]);

        // choose - sign
        int minus = solve(nums, target, i + 1, currSum - nums[i]);

        // total ways
        return plus + minus;
    }

    public static int findTargetSumWays(int[] nums, int target)
    {
        return solve(nums, target, 0, 0);
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        System.out.println(findTargetSumWays(nums, target));
    }
}

/*
==================== FULL DRY RUN ====================

nums = [1, 1, 1, 1, 1]
target = 3

Call:
solve(nums, 3, 0, 0)

------------------------------------------------
i = 0, currSum = 0
+1 → solve(1, 1)
-1 → solve(1, -1)

------------------------------------------------
i = 1, currSum = 1
+1 → solve(2, 2)
-1 → solve(2, 0)

i = 1, currSum = -1
+1 → solve(2, 0)
-1 → solve(2, -2)

------------------------------------------------
i = 2, currSum = 2
+1 → solve(3, 3)
-1 → solve(3, 1)

i = 2, currSum = 0
+1 → solve(3, 1)
-1 → solve(3, -1)

------------------------------------------------
i = 3, currSum = 3
+1 → solve(4, 4)
-1 → solve(4, 2)

------------------------------------------------
i = 4, currSum = 4
+1 → solve(5, 5) ❌
-1 → solve(5, 3) ✅ (TARGET HIT)

------------------------------------------------
Similarly all branches continue...

Valid paths (sum = 3):
+ + + - -
+ + - + -
+ - + + -
- + + + -
+ + + + -

------------------------------------------------
FINAL ANSWER:
5 ways

===================================================
*/
