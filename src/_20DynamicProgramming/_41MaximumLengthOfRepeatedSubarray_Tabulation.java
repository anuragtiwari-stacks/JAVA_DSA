package _20DynamicProgramming;

public class _41MaximumLengthOfRepeatedSubarray_Tabulation
{
    public static int findLength(int[] nums1, int[] nums2)
    {
        int n = nums1.length;
        int m = nums2.length;

        int[][] dp = new int[n + 1][m + 1];

        int max = 0;

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(nums1[i-1]==nums2[j-1])
                {
                    dp[i][j]=1+dp[i-1][j-1];

                    max= Math.max(max,dp[i][j]);
                }
                else
                {
                    dp[i][j]=0;
                }
            }
        }
        return max;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {1, 2, 3, 2, 1};

        int[] nums2 = {3, 2, 1, 4, 7};

        System.out.println(findLength(nums1, nums2));
    }
}