package _17DynamicProgramming;

public class _33LongestIncreasingSubsequence
{
    public static int lengthOfLIS(int[] nums)
    {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j <= i - 1; j++)
            {
                if(nums[j] < nums[i])
                {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += 1;
        }
        int max = dp[0];
        for(int i = 1; i < n; i++)
        {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args)
    {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int result = lengthOfLIS(nums);
        System.out.println("Length of LIS = " + result);
    }
}

/*
===================== DP TABLE (Same Example) =====================

nums = [10,9,2,5,3,7,101,18]

After filling dp (without max inside loop):

dp = [1,1,1,2,2,3,4,4]

Now max:

max = 4

Output:
Length of LIS = 4
==================================================================
*/
