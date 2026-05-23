package _20DynamicProgramming;

// Longest Palindromic Subsequence using LCS pattern
public class _24LongestPalindromicSubsequence_LCS
{
    public static int longestPalindromeSubseq(String s)
    {
        String rev = reverseString(s);

        int n = s.length();
        int m = rev.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= m; j++)
            {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i <= n; i++)
        {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= m; j++)
        {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (s.charAt(i - 1) == rev.charAt(j - 1))
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    private static String reverseString(String s)
    {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public static void main(String[] args)
    {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }
}

/*
FINAL DP TABLE (LPS using LCS)

Original string  = "bbbab"
Reversed string  = "babbb"

      ""  b  a  b  b  b
   ----------------------
"" |  0  0  0  0  0  0
b  |  0  1  1  1  1  1
b  |  0  1  1  2  2  2
b  |  0  1  1  2  3  3
a  |  0  1  2  2  3  3
b  |  0  1  2  3  3  4

FINAL ANSWER:
Longest Palindromic Subsequence length = 4
Example: "bbbb"
*/
