package _17DynamicProgramming;

// LeetCode 1312 - Minimum Insertion Steps to Make a String Palindrome
public class _27MinimumInsertionsPalindrome
{
    public static int minInsertions(String s)
    {
        String rev = new StringBuilder(s).reverse().toString();

        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];

        // initialize dp with -1
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                dp[i][j] = -1;
            }
        }

        // base cases
        for (int i = 0; i <= n; i++)
        {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= n; j++)
        {
            dp[0][j] = 0;
        }

        // LCS between s and reverse(s)
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (s.charAt(i - 1) == rev.charAt(j - 1))
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

        int lps = dp[n][n];
        return n - lps;
    }

    public static void main(String[] args)
    {
        String s = "mbadm";
        System.out.println(minInsertions(s));
    }
}

/*
==================== EXPLANATION (USING IMAGE IDEA) ====================

Formula:
Minimum Insertions = s.length() - LPS(s)

------------------------------------------------
How to find LPS?
LPS(s) = LCS(s, reverse(s))

------------------------------------------------
Example 1:
s = "mbadm"
reverse(s) = "mdabm"

LCS(s, reverse(s)) = "mam" or "mbm"
LPS length = 3

Minimum Insertions = 5 - 3 = 2

Possible Palindromes (from image):
1) m b d a d b m
2) m d b a b d m

------------------------------------------------
Example 2 (from image):
s = "abcdba"
reverse = "abdcba"

LPS = "abdba" (length = 5)
Minimum Insertions = 6 - 5 = 1

------------------------------------------------
DP Meaning:
dp[i][j] = LCS length of
           s[0..i-1] and reverse(s)[0..j-1]

------------------------------------------------


================================================
*/
