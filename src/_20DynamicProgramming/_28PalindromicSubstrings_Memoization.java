package _20DynamicProgramming;

// LeetCode 647

public class _28PalindromicSubstrings_Memoization
{
    public static int countSubstrings(String s)
    {
        int n = s.length();
        Boolean [][] dp = new Boolean[n][n];

        int count = 0;

        for (int i = 0; i < n; i++)
        {
            for (int j = i; j < n; j++)
            {
                if (isPalindrome(s, i, j , dp))
                {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean isPalindrome(String s, int l, int r, Boolean [][] dp)
    {
        if(l>=r)
        {
            return true;
        }

        if(dp[l][r]!=null)
        {
            return dp[l][r];
        }

        if(s.charAt(l)==s.charAt(r))
        {
            return dp[l][r]=isPalindrome(s,l+1,r-1,dp);
        }

        return false;
    }

    public static void main(String[] args)
    {
        String s = "aaa";

        System.out.println(countSubstrings(s));
    }
}
