package _7PrefixSum;

public class _3FindPivotIndexUsingPrefix
{

    // Method to find pivot index using prefix sum
    public static int pivotIndex(int[] nums)
    {
        int n = nums.length;

        // Prefix sum array
        int[] prefix = new int[n];

        // Build prefix sum
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++)
        {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        // Check each index as pivot
        for (int i = 0; i < n; i++)
        {
            int leftSum;
            int rightSum;

            // Left sum
            if (i == 0)
            {
                leftSum = 0;
            }
            else
            {
                leftSum = prefix[i - 1];
            }

            // Right sum
            rightSum = prefix[n - 1] - prefix[i];

            // Pivot condition
            if (leftSum == rightSum)
            {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args)
    {
        int[] nums = { 1, 7, 3, 6, 5, 6 };

        int pivot = pivotIndex(nums);

        System.out.println("Pivot Index = " + pivot);
    }
}

/*
=====================
DRY RUN
=====================

nums = { 1, 7, 3, 6, 5, 6 }
index   0  1  2  3  4  5

Prefix Sum:
prefix[0] = 1
prefix[1] = 1 + 7  = 8
prefix[2] = 8 + 3  = 11
prefix[3] = 11 + 6 = 17
prefix[4] = 17 + 5 = 22
prefix[5] = 22 + 6 = 28

prefix = { 1, 8, 11, 17, 22, 28 }

Check pivot:

i = 0
leftSum  = 0
rightSum = prefix[5] - prefix[0]
         = 28 - 1 = 27 ❌

i = 1
leftSum  = prefix[0] = 1
rightSum = 28 - 8 = 20 ❌

i = 2
leftSum  = prefix[1] = 8
rightSum = 28 - 11 = 17 ❌

i = 3
leftSum  = prefix[2] = 11
rightSum = 28 - 17 = 11 ✅

Pivot Index = 3
*/
