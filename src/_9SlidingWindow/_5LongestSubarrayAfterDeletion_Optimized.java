package _9SlidingWindow;

public class _5LongestSubarrayAfterDeletion_Optimized
{
    public int longestSubarray(int[] nums)
    {
        int i = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int j = 0; j < nums.length; j++)
        {
            if (nums[j] == 0)
            {
                zeroCount++;
            }

            while (zeroCount > 1)
            {
                if (nums[i] == 0)
                {
                    zeroCount--;
                }
                i++;
            }

            // length excluding one deleted element
            maxLen = Math.max(maxLen, j - i);
        }

        if (maxLen == nums.length)
        {
            return maxLen - 1;
        }

        return maxLen;
    }

    public static void main(String[] args)
    {
        _5LongestSubarrayAfterDeletion_Optimized sol = new _5LongestSubarrayAfterDeletion_Optimized();

        int[] nums1 = {1, 1, 0, 1};
        System.out.println(sol.longestSubarray(nums1)); // 3

        int[] nums2 = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        System.out.println(sol.longestSubarray(nums2)); // 5

        int[] nums3 = {1, 1, 1};
        System.out.println(sol.longestSubarray(nums3)); // 2
    }
}

/*
==================== DRY RUN ====================

Example 1:
nums = [1, 1, 0, 1]

i = 0, zeroCount = 0, maxLen = 0

j = 0 → nums[j] = 1
zeroCount = 0
maxLen = max(0, 0 - 0) = 0

j = 1 → nums[j] = 1
zeroCount = 0
maxLen = max(0, 1 - 0) = 1

j = 2 → nums[j] = 0
zeroCount = 1
maxLen = max(1, 2 - 0) = 2

j = 3 → nums[j] = 1
zeroCount = 1
maxLen = max(2, 3 - 0) = 3

Final Answer = 3


Example 2:
nums = [0,1,1,1,0,1,1,0,1]

i = 0, zeroCount = 0, maxLen = 0

j = 0 → 0
zeroCount = 1
maxLen = 0

j = 1 → 1
zeroCount = 1
maxLen = 1

j = 2 → 1
zeroCount = 1
maxLen = 2

j = 3 → 1
zeroCount = 1
maxLen = 3

j = 4 → 0
zeroCount = 2 → too many zeros
shrink window:
i = 0 → nums[i]=0 → zeroCount=1, i=1

maxLen = max(3, 4 - 1) = 3

j = 5 → 1
maxLen = max(3, 5 - 1) = 4

j = 6 → 1
maxLen = max(4, 6 - 1) = 5

j = 7 → 0
zeroCount = 2
shrink:
i moves until one zero removed

j = 8 → 1
maxLen remains 5

Final Answer = 5


Example 3:
nums = [1,1,1]

All ones → maxLen becomes 3
Must delete one element
Return 3 - 1 = 2

===============================================
*/
