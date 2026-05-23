package _20DynamicProgramming;

// LeetCode 2786 - Visit Array Positions to Maximize Score

public class _18VisitArrayPositionsMaxScore
{
    public static long maxScore(int[] nums, int x)
    {
        long even = Long.MIN_VALUE;
        long odd = Long.MIN_VALUE;

        // initialize using first element
        if (nums[0] % 2 == 0)
        {
            even = nums[0];
        }
        else
        {
            odd = nums[0];
        }

        for (int i = 1; i < nums.length; i++)
        {
            // current number is even
            if (nums[i] % 2 == 0)
            {
                even = Math.max(
                        even + nums[i],      // same parity
                        odd + nums[i] - x    // parity change
                );
            }

            // current number is odd
            else
            {
                odd = Math.max(
                        odd + nums[i],       // same parity
                        even + nums[i] - x   // parity change
                );
            }
        }

        return Math.max(even, odd);
    }

    public static void main(String[] args)
    {
        int[] nums = {2, 3, 6, 1, 9, 2};
        int x = 5;

        System.out.println(maxScore(nums, x));
    }
}