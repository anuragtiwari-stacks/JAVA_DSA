package _17DynamicProgramming;

// LeetCode 583 - Delete Operation for Two Strings
public class _28DeleteOperationTwoStrings
{
    public static int minDistance(String word1, String word2)
    {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        // manually fill dp with 0
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= m; j++)
            {
                dp[i][j] = 0;
            }
        }

        // base cases:
        // if word2 is empty -> delete all from word1
        for (int i = 0; i <= n; i++)
        {
            dp[i][0] = i;
        }

        // if word1 is empty -> delete all from word2
        for (int j = 0; j <= m; j++)
        {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else
                {
                    int deleteFromWord1 = dp[i - 1][j];
                    int deleteFromWord2 = dp[i][j - 1];

                    dp[i][j] = 1 + Math.min(
                            deleteFromWord1,
                            deleteFromWord2
                    );
                }
            }
        }

        return dp[n][m];
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

dp[i][j] = minimum deletions to make
           word1[0..i-1] and word2[0..j-1] equal

Base:
dp[i][0] = i   (delete all from word1)
dp[0][j] = j   (delete all from word2)

-----------------------------------------------
DP Table:

      ""  e  a  t
   ----------------
"" |  0  1  2  3
s  |  1  2  3  4
e  |  2  1  2  3
a  |  3  2  1  2

-----------------------------------------------
Final Answer:
dp[3][3] = 2

Explanation:
Delete 's' from "sea"
Delete 't' from "eat"
Both become "ea"

===============================================
*/
