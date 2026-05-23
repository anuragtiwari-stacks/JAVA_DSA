package _20DynamicProgramming;

// LeetCode 72 - Edit Distance (DP - Tabulation)
public class _21EditDistance_Tabulation
{
    public static int minDistance(String word1, String word2)
    {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        // MANUALLY fill dp with 0
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= m; j++)
            {
                dp[i][j] = 0;
            }
        }

        // base cases
        for (int i = 0; i <= n; i++)
        {
            dp[i][0] = i;   // delete all characters
        }

        for (int j = 0; j <= m; j++)
        {
            dp[0][j] = j;   // insert all characters
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
                    int insert  = dp[i][j - 1];
                    int delete  = dp[i - 1][j];
                    int replace = dp[i - 1][j - 1];

                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args)
    {
        String word1 = "horse";
        String word2 = "ros";

        System.out.println(minDistance(word1, word2));
    }
}

/*
==================== DRY RUN ====================

word1 = "horse"
word2 = "ros"

dp[i][j] = minimum operations to convert
           word1[0..i-1] → word2[0..j-1]

Base Initialization:
dp[i][0] = i   (delete i chars)
dp[0][j] = j   (insert j chars)

-----------------------------------------------
DP Table:

      ""  r  o  s
   ----------------
"" |  0  1  2  3
h  |  1  1  2  3
o  |  2  2  1  2
r  |  3  2  2  2
s  |  4  3  3  2
e  |  5  4  4  3

-----------------------------------------------
Final Answer:
dp[5][3] = 3

Operations:
horse → rorse (replace)
rorse → rose  (delete)
rose  → ros   (delete)
===============================================
*/
