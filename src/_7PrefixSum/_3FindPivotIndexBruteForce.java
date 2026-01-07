package _7PrefixSum;

public class _3FindPivotIndexBruteForce
{
    // Brute force method to find pivot index
    public static int pivotIndex(int[] nums)
    {
        int n = nums.length;

        // Check each index as pivot
        for (int i = 0; i < n; i++)
        {
            int leftSum = 0;
            int rightSum = 0;

            // Calculate left sum
            for (int j = 0; j < i; j++)
            {
                leftSum = leftSum + nums[j];
            }

            // Calculate right sum
            for (int j = i + 1; j < n; j++)
            {
                rightSum = rightSum + nums[j];
            }

            // Check pivot condition
            if (leftSum == rightSum)
            {
                return i;
            }
        }

        // If no pivot index found
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

Index 0:
leftSum = 0
rightSum = 7 + 3 + 6 + 5 + 6 = 27
leftSum != rightSum

Index 1:
leftSum = 1
rightSum = 3 + 6 + 5 + 6 = 20
leftSum != rightSum

Index 2:
leftSum = 1 + 7 = 8
rightSum = 6 + 5 + 6 = 17
leftSum != rightSum

Index 3:
leftSum = 1 + 7 + 3 = 11
rightSum = 5 + 6 = 11
leftSum == rightSum ✅

Pivot Index = 3
*/
