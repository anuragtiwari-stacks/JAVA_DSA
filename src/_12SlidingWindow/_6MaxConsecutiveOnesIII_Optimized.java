package _12SlidingWindow;

public class _6MaxConsecutiveOnesIII_Optimized
{
    public int longestOnes(int[] nums, int k)
    {
        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++)
        {
            if (nums[right] == 0)
            {
                zeroCount++;
            }

            // shrink window if zero count exceeds k
            while (zeroCount > k)
            {
                if (nums[left] == 0)
                {
                    zeroCount--;
                }
                left++;
            }

            // update maximum window size
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args)
    {
        _6MaxConsecutiveOnesIII_Optimized sol =
                new _6MaxConsecutiveOnesIII_Optimized();

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

left = 0, zeroCount = 0, maxLen = 0

--------------------------------------------------------
right = 0 -> nums[0] = 1
zeroCount = 0
window = [0..0] -> length = 1
maxLen = 1

--------------------------------------------------------
right = 1 -> nums[1] = 1
zeroCount = 0
window = [0..1] -> length = 2
maxLen = 2

--------------------------------------------------------
right = 2 -> nums[2] = 1
zeroCount = 0
window = [0..2] -> length = 3
maxLen = 3

--------------------------------------------------------
right = 3 -> nums[3] = 0
zeroCount = 1
window = [0..3] -> length = 4
maxLen = 4

--------------------------------------------------------
right = 4 -> nums[4] = 0
zeroCount = 2
window = [0..4] -> length = 5
maxLen = 5

--------------------------------------------------------
right = 5 -> nums[5] = 0
zeroCount = 3 (>k)

Shrink window:
left = 0 -> nums[0] = 1 -> left = 1
left = 1 -> nums[1] = 1 -> left = 2
left = 2 -> nums[2] = 1 -> left = 3
left = 3 -> nums[3] = 0 -> zeroCount = 2, left = 4

window = [4..5] -> length = 2
maxLen = 5

--------------------------------------------------------
right = 6 -> nums[6] = 1
window = [4..6] -> length = 3

--------------------------------------------------------
right = 7 -> nums[7] = 1
window = [4..7] -> length = 4

--------------------------------------------------------
right = 8 -> nums[8] = 1
window = [4..8] -> length = 5

--------------------------------------------------------
right = 9 -> nums[9] = 1
window = [4..9] -> length = 6
maxLen = 6  ✅

--------------------------------------------------------
right = 10 -> nums[10] = 0
zeroCount = 3 (>k)

Shrink window:
left = 4 -> nums[4] = 0 -> zeroCount = 2, left = 5

window = [5..10] -> length = 6
maxLen = 6

--------------------------------------------------------
Final Answer = 6
========================================================
*/
