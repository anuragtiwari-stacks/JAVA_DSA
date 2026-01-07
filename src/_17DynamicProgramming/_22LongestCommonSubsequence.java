package _17DynamicProgramming;

// LeetCode 1143 - Longest Common Subsequence
public class _22LongestCommonSubsequence
{
    public static int longestCommonSubsequence(String text1, String text2)
    {
        int n = text1.length();
        int m = text2.length();

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
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else
                {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i][j - 1]
                    );
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args)
    {
        String text1 = "abcde";
        String text2 = "ace";

        System.out.println(longestCommonSubsequence(text1, text2));
    }
}

/*
FINAL DP TABLE (LCS)

text1 = "abcde"
text2 = "ace"

      ""  a  c  e
   ----------------
"" |  0  0  0  0
a  |  0  1  1  1
b  |  0  1  1  1
c  |  0  1  2  2
d  |  0  1  2  2
e  |  0  1  2  3

FINAL ANSWER:
dp[5][3] = 3
*/
