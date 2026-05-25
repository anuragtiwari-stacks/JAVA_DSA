package _20DynamicProgramming;

public class _41MaximumLengthOfRepeatedSubarray_Recurssion
{
    static int maxLen = 0;

    public static int findLength(int[] nums1, int[] nums2)
    {
        solve(nums1, nums2, 0, 0);

        return maxLen;
    }

    public static int solve(int[] nums1, int[] nums2, int i, int j)
    {
        if(i == nums1.length || j == nums2.length)
        {
            return 0;
        }

        int count = 0;

        if(nums1[i] == nums2[j])
        {
            count = 1 + solve(nums1, nums2, i + 1, j + 1);

            maxLen = Math.max(maxLen, count);
        }

        solve(nums1, nums2, i + 1, j);

        solve(nums1, nums2, i, j + 1);

        return count;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {1, 2, 3, 2, 1};

        int[] nums2 = {3, 2, 1, 4, 7};

        System.out.println(findLength(nums1, nums2));
    }
}