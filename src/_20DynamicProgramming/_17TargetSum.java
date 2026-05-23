package _20DynamicProgramming;

// LeetCode 494 - Target Sum (Recursion Only)

public class _17TargetSum
{
    public static int solve(int[] nums, int target, int i, int currSum)
    {
        // base case
        if (i == nums.length)
        {
            if (currSum == target)
            {
                return 1;
            }

            return 0;
        }

        // + sign
        int plus = solve(nums, target, i + 1, currSum + nums[i]);

        // - sign
        int minus = solve(nums, target, i + 1, currSum - nums[i]);

        return plus + minus;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        int ans = solve(nums, target, 0, 0);

        System.out.println(ans);
    }
}

/*
nums = [1,1,1]
target = 1

                          (i=0,sum=0)
                           /        \
                        +1            -1
                       /                \
              (i=1,sum=1)         (i=1,sum=-1)
                 /      \             /       \
              +1        -1         +1        -1
             /            \        /            \
     (2,2)               (2,0)  (2,0)        (2,-2)
        / \               / \      / \          / \
      +1 -1             +1 -1    +1 -1       +1 -1
      /    \            /    \    /    \      /    \
   (3,3)(3,1)       (3,1)(3,-1)(3,1)(3,-1)(3,-1)(3,-3)
*/

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
