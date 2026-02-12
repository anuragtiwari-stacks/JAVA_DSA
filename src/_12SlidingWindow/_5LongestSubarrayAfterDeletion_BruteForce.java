package _12SlidingWindow;

public class _5LongestSubarrayAfterDeletion_BruteForce
{
    public int longestSubarray(int[] nums)
    {
        int n = nums.length;
        int maxLen = 0;

        // Fix i (starting index)
        for (int i = 0; i < n; i++)
        {
            int zeroCount = 0;

            // Expand j from i
            for (int j = i; j < n; j++)
            {
                if (nums[j] == 0)
                {
                    zeroCount++;
                }

                // We can delete only one element (one zero allowed)
                if (zeroCount > 1)
                {
                    break;
                }

                // length after deleting one element
                int currentLength = j - i;
                if (currentLength > maxLen)
                {
                    maxLen = currentLength;
                }
            }
        }

        // If all elements are 1, we must delete one
        if (maxLen == n)
        {
            return n - 1;
        }

        return maxLen;
    }

    public static void main(String[] args)
    {
        _5LongestSubarrayAfterDeletion_BruteForce sol =
                new _5LongestSubarrayAfterDeletion_BruteForce();

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

Example:
nums = [1, 1, 0, 1]

i = 0:
 j = 0 → [1], zeroCount = 0 → length = 0
 j = 1 → [1,1], zeroCount = 0 → length = 1
 j = 2 → [1,1,0], zeroCount = 1 → length = 2
 j = 3 → [1,1,0,1], zeroCount = 1 → length = 3
 maxLen = 3

i = 1:
 j = 1 → [1], zeroCount = 0 → length = 0
 j = 2 → [1,0], zeroCount = 1 → length = 1
 j = 3 → [1,0,1], zeroCount = 1 → length = 2

i = 2:
 j = 2 → [0], zeroCount = 1 → length = 0
 j = 3 → [0,1], zeroCount = 1 → length = 1

i = 3:
 j = 3 → [1], zeroCount = 0 → length = 0

Final Answer = 3

===============================================

Time Complexity: O(n²)
Space Complexity: O(1)
*/
