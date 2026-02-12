package _10PrefixSum;

public class _4ScoreOfAllPrefixes
{

    // Method to find score of all prefixes
    public static long[] findPrefixScore(int[] nums)
    {
        int n = nums.length;

        int[] pmax = new int[n];
        long[] sum = new long[n];
        long[] psum = new long[n];

        // Step 1: Build prefix maximum array
        pmax[0] = nums[0];

        for (int i = 1; i < n; i++)
        {
            pmax[i] = Math.max(pmax[i - 1], nums[i]);
        }

        // Step 2: Build sum array (nums[i] + pmax[i])
        for (int i = 0; i < n; i++)
        {
            sum[i] = nums[i] + pmax[i];
        }

        // Step 3: Build prefix sum of sum array
        psum[0] = sum[0];

        for (int i = 1; i < n; i++)
        {
            psum[i] = psum[i - 1] + sum[i];
        }

        return psum;
    }

    public static void main(String[] args)
    {
        int[] nums = { 2, 3, 7, 5, 10 };

        long[] result = findPrefixScore(nums);

        for (int i = 0; i < result.length; i++)
        {
            System.out.print(result[i] + " ");
        }
    }
}

/*
=====================
DRY RUN
=====================

nums = { 2, 3, 7, 5, 10 }

Step 1: pmax
pmax = { 2, 3, 7, 7, 10 }

Step 2: sum
sum[0] = 2 + 2  = 4
sum[1] = 3 + 3  = 6
sum[2] = 7 + 7  = 14
sum[3] = 5 + 7  = 12
sum[4] = 10 + 10 = 20

sum = { 4, 6, 14, 12, 20 }

Step 3: psum
psum[0] = 4
psum[1] = 4 + 6  = 10
psum[2] = 10 + 14 = 24
psum[3] = 24 + 12 = 36
psum[4] = 36 + 20 = 56

Final Answer:
{ 4, 10, 24, 36, 56 }
*/
