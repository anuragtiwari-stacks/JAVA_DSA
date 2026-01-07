package _17DynamicProgramming;

// LeetCode 583 - Delete Operation for Two Strings (Using LCS Formula)
public class _28DeleteOperationTwoStrings_LCS
{
    public static int minDistance(String word1, String word2)
    {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        // initialize dp with -1
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= m; j++)
            {
                dp[i][j] = -1;
            }
        }

        // base cases
        for (int i = 0; i <= n; i++)
        {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++)
        {
            dp[0][j] = 0;
        }

        // LCS tabulation
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
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

        int lcs = dp[n][m];
        return n + m - 2 * lcs;
    }

    public static void main(String[] args)
    {
        String word1 = "sea";
        String word2 = "eat";

        System.out.println(minDistance(word1, word2));
    }
}

/*
==================== DRY RUN ====================

word1 = "sea"
word2 = "eat"

LCS = "ea"
LCS length = 2

n = 3, m = 3

Minimum Deletions
= n + m - 2 * LCS
= 3 + 3 - 2*2
= 2

Delete 's' from "sea"
Delete 't' from "eat"

Both become "ea"
===============================================
*/
