package _17DynamicProgramming;

// LeetCode 2786 - Visit Array Positions to Maximize Score
public class _21VisitArrayPositionsMaxScore
{
    public static int maxScore(int[] nums, int x)
    {
        int evenScore = Integer.MIN_VALUE;
        int oddScore  = Integer.MIN_VALUE;

        // initialize with first element
        if (nums[0] % 2 == 0)
        {
            evenScore = nums[0];
        }
        else
        {
            oddScore = nums[0];
        }

        for (int i = 1; i < nums.length; i++)
        {
            int val = nums[i];

            if (val % 2 == 0)
            {
                int sameParity   = evenScore + val;
                int changeParity = oddScore + val - x;

                int newEven = Math.max(sameParity, changeParity);
                evenScore = Math.max(evenScore, newEven);
            }
            else
            {
                int sameParity   = oddScore + val;
                int changeParity = evenScore + val - x;

                int newOdd = Math.max(sameParity, changeParity);
                oddScore = Math.max(oddScore, newOdd);
            }
        }

        return Math.max(evenScore, oddScore);
    }

    public static void main(String[] args)
    {
        int[] nums = {2, 3, 6, 1, 9, 2};
        int x = 5;

        System.out.println(maxScore(nums, x));
    }
}
