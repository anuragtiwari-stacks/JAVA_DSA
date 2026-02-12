package _15Greedy.MIK;
// LeetCode 945: Minimum Increment to Make Array Unique

import java.util.*;

public class _27MinIncrementForUnique
{
    static class Solution
    {
        public int minIncrementForUnique(int[] nums)
        {
            Arrays.sort(nums);
            int moves = 0;

            for (int i = 1; i < nums.length; i++)
            {
                if (nums[i] <= nums[i - 1])
                {
                    int newVal = nums[i - 1] + 1;
                    moves = moves + (newVal - nums[i]);
                    nums[i] = newVal;
                }
            }

            return moves;
        }
    }

    public static void main(String[] args)
    {
        Solution obj = new Solution();

        int[] nums = {1, 1, 2, 2, 3, 7};
        int ans = obj.minIncrementForUnique(nums);

        System.out.println("Output = " + ans);
    }
}


/*
===================== DRY RUN =====================

Input:
[1, 1, 2, 2, 3, 7]

Sorted:
[1, 1, 2, 2, 3, 7]

i = 1:
nums[1] = 1 <= 1
newVal = 2
moves += 2 - 1 = 1
nums = [1, 2, 2, 2, 3, 7]

i = 2:
nums[2] = 2 <= 2
newVal = 3
moves += 3 - 2 = 1
nums = [1, 2, 3, 2, 3, 7]

i = 3:
nums[3] = 2 <= 3
newVal = 4
moves += 4 - 2 = 2
nums = [1, 2, 3, 4, 3, 7]

i = 4:
nums[4] = 3 <= 4
newVal = 5
moves += 5 - 3 = 2
nums = [1, 2, 3, 4, 5, 7]

i = 5:
nums[5] = 7 > 5 (OK)

Total moves = 1 + 1 + 2 + 2 = 6

===================================================
*/
