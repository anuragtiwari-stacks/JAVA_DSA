/*
1. Two Sum

Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up to target.
*/

package _5Hashing._2HashMap;

import java.util.HashMap;

public class _3TwoSum
{
    public static int[] twoSum(int[] nums, int target)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
        {
            int need = target - nums[i];

            if (map.containsKey(need))
            {
                return new int[]{map.get(need), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args)
    {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] ans = twoSum(nums, target);

        System.out.println(ans[0] + " " + ans[1]);
    }
}

/*
==================== FULL DRY RUN ====================

Input:
nums = [2, 7, 11, 15]
target = 9

Initial State:
map = {}
------------------------------------------------------

Iteration 1:
i = 0
nums[i] = 2

need = target - nums[i]
need = 9 - 2 = 7

Check:
map.containsKey(7) → false

Action:
put (2, 0) into map

map now:
{2 = 0}
------------------------------------------------------

Iteration 2:
i = 1
nums[i] = 7

need = target - nums[i]
need = 9 - 7 = 2

Check:
map.containsKey(2) → true

Index found:
map.get(2) = 0

Result:
indices = [0, 1]

Return answer and stop execution.
------------------------------------------------------

Final Output:
0 1
======================================================
*/
