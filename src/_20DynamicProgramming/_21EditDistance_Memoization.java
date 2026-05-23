package _20DynamicProgramming;

// LeetCode 72 - Edit Distance (Memoization)

public class _21EditDistance_Memoization
{
    static int[][] dp;

    public static int minDistance(String word1, String word2)
    {
        int n = word1.length();
        int m = word2.length();

        dp = new int[n][m];

        // initialize dp with -1
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                dp[i][j] = -1;
            }
        }

        return solve(word1, word2, 0, 0);
    }

    public static int solve(String s1, String s2, int i, int j)
    {
        // base case
        if (i == s1.length())
        {
            // insert remaining chars of s2
            return s2.length() - j;
        }

        if (j == s2.length())
        {
            // delete remaining chars of s1
            return s1.length() - i;
        }

        // already calculated
        if (dp[i][j] != -1)
        {
            return dp[i][j];
        }

        // characters match
        if (s1.charAt(i) == s2.charAt(j))
        {
            return dp[i][j] = solve(s1, s2, i + 1, j + 1);
        }

        int insert = 1 + solve(s1, s2, i, j + 1);

        int delete = 1 + solve(s1, s2, i + 1, j);

        int replace = 1 + solve(s1, s2, i + 1, j + 1);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }

    public static void main(String[] args)
    {
        String word1 = "horse";
        String word2 = "ros";

        System.out.println(minDistance(word1, word2));
    }
}