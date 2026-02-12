package _12SlidingWindow;

public class _6MaxConsecutiveOnesIII_BruteForce
{
    public int longestOnes(int[] nums, int k)
    {
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++)
        {
            int zeroCount = 0;

            for (int j = i; j < nums.length; j++)
            {
                if (nums[j] == 0)
                {
                    zeroCount++;
                }

                if (zeroCount > k)
                {
                    break;
                }

                maxLen = Math.max(maxLen, j - i + 1);
            }
        }

        return maxLen;
    }

    public static void main(String[] args)
    {
        _6MaxConsecutiveOnesIII_BruteForce sol =
                new _6MaxConsecutiveOnesIII_BruteForce();

        int[] nums1 = {1,1,1,0,0,0,1,1,1,1,0};
        int k1 = 2;

        System.out.println(sol.longestOnes(nums1, k1)); // Expected: 6
    }
}

/*
======================== DRY RUN ========================

Input:
nums = [1,1,1,0,0,0,1,1,1,1,0]
k = 2

--------------------------------------------------------
i = 0
--------------------------------------------------------
j = 0 -> [1]                 zeroCount = 0   length = 1
j = 1 -> [1,1]               zeroCount = 0   length = 2
j = 2 -> [1,1,1]             zeroCount = 0   length = 3
j = 3 -> [1,1,1,0]           zeroCount = 1   length = 4
j = 4 -> [1,1,1,0,0]         zeroCount = 2   length = 5
j = 5 -> [1,1,1,0,0,0]       zeroCount = 3  (>k) → break

maxLen = 5

--------------------------------------------------------
i = 1
--------------------------------------------------------
j = 1 -> [1]                 zeroCount = 0   length = 1
j = 2 -> [1,1]               zeroCount = 0   length = 2
j = 3 -> [1,1,0]             zeroCount = 1   length = 3
j = 4 -> [1,1,0,0]           zeroCount = 2   length = 4
j = 5 -> [1,1,0,0,0]         zeroCount = 3  (>k) → break

maxLen = 5

--------------------------------------------------------
i = 4   (IMPORTANT CASE)
--------------------------------------------------------
j = 4 -> [0]                 zeroCount = 1   length = 1
j = 5 -> [0,0]               zeroCount = 2   length = 2
j = 6 -> [0,0,1]             zeroCount = 2   length = 3
j = 7 -> [0,0,1,1]           zeroCount = 2   length = 4
j = 8 -> [0,0,1,1,1]         zeroCount = 2   length = 5
j = 9 -> [0,0,1,1,1,1]       zeroCount = 2   length = 6
j = 10 -> [0,0,1,1,1,1,0]    zeroCount = 3  (>k) → break

maxLen = 6  ✅

--------------------------------------------------------
Remaining i values do not produce a longer subarray.

Final Answer = 6
========================================================
*/
