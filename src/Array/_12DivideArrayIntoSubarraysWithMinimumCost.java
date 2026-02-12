package Array;

// LeetCode 3010
// Divide an Array Into Subarrays With Minimum Cost I

public class _12DivideArrayIntoSubarraysWithMinimumCost
{
    public static int minimumCost(int[] nums)
    {
        int startElement = nums[0];

        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] < firstMin)
            {
                secondMin = firstMin;
                firstMin = nums[i];
            }
            else if(nums[i] < secondMin)
            {
                secondMin = nums[i];
            }
        }

        return startElement + firstMin + secondMin;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {1, 2, 3, 12};
        System.out.println(minimumCost(nums1)); // 6

        int[] nums2 = {5, 4, 3};
        System.out.println(minimumCost(nums2)); // 12

        int[] nums3 = {10, 3, 1, 1};
        System.out.println(minimumCost(nums3)); // 12
    }
}

/*
Logic:
- First subarray always starts at index 0, so nums[0] is always included.
- Remaining two subarrays can start at any two indices from nums[1...n-1].
- To minimize total cost, we select the two smallest elements from nums[1...n-1].
- Final answer = nums[0] + smallest + secondSmallest.

Dry Run:

Input:
nums = [1, 2, 3, 12]

Step 1:
startElement = 1

Step 2:
Remaining elements = [2, 3, 12]
firstMin = 2
secondMin = 3

Step 3:
Total Cost = 1 + 2 + 3 = 6

Output:
6
*/
