/*
Given an array of positive integers nums and a positive integer target,
return the minimal length of a subarray whose sum is greater than or equal to target.
If there is no such subarray, return 0 instead.

Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1
*/

package _12SlidingWindow;

public class _3
{

    public static int minSubArrayLenBruteForce(int target, int[] nums)
    {
        int minLength = Integer.MAX_VALUE;

        for (int start = 0; start < nums.length; start++)
        {
            int sum = 0;

            for (int end = start; end < nums.length; end++)
            {
                sum += nums[end];

                if (sum >= target)
                {
                    minLength = Math.min(minLength, end - start + 1);
                    break;
                }
            }
        }

        if (minLength == Integer.MAX_VALUE)
        {
            return 0;
        }
        else
        {
            return minLength;
        }
    }

    public static void main(String[] args)
    {
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        int target = 7;

        int result = minSubArrayLenBruteForce(target, nums);

        System.out.println("Minimum size subarray sum ≥ " + target + " is: " + result);
    }

}
