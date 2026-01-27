package Array_String;

// LeetCode 3818

public class _10MinimumPrefixRemovalToMakeArrayStrictlyIncreasing
{
    public static int minimumPrefix(int[] nums)
    {
        int n = nums.length;

        if(n <= 1)
        {
            return 0;
        }

        int idx = n - 1;

        while(idx > 0 && nums[idx - 1] < nums[idx])
        {
            idx--;
        }

        return idx;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {1, -1, 2, 3, 4, 5};
        int[] nums2 = {4, 3, -2, -5};

        System.out.println(minimumPrefix(nums1));
        System.out.println(minimumPrefix(nums2));
    }
}

/*
Dry Run:

Example 1:
Input: nums = [1, -1, 2, 3, 4, 5]

n = 6
idx starts at 5

idx = 5: compare nums[4] (4) < nums[5] (5)  -> true -> idx = 4
idx = 4: compare nums[3] (3) < nums[4] (4)  -> true -> idx = 3
idx = 3: compare nums[2] (2) < nums[3] (3)  -> true -> idx = 2
idx = 2: compare nums[1] (-1) < nums[2] (2) -> true -> idx = 1
idx = 1: compare nums[0] (1) < nums[1] (-1) -> false -> stop

Return idx = 1

Remaining suffix = [-1, 2, 3, 4, 5]

Example 2:
Input: nums = [4, 3, -2, -5]

n = 4
idx starts at 3

idx = 3: nums[2] (-2) < nums[3] (-5)? -> false

Return idx = 3

Remaining suffix = [-5]  (strictly increasing by itself)

Output:
1
3
*/
