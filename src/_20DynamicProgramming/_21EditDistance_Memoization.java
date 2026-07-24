package _20DynamicProgramming;

// LeetCode 72 - Edit Distance (Forward Recursion + Memoization)
public class _21EditDistance_Memoization
{
    public static int minDistance(String word1, String word2)
    {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m][n];

        // Initialize dp with -1 using nested loops
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                dp[i][j] = -1;
            }
        }

        return solve(word1, word2, 0, 0, dp);
    }

    private static int solve(String s1, String s2, int i, int j, int[][] dp)
    {
        int m = s1.length();
        int n = s2.length();

        // s1 finished
        if (i == m)
        {
            return n - j;
        }

        // s2 finished
        if (j == n)
        {
            return m - i;
        }

        // already calculated
        if (dp[i][j] != -1)
        {
            return dp[i][j];
        }

        // characters match
        if (s1.charAt(i) == s2.charAt(j))
        {
            return dp[i][j] = solve(s1, s2, i + 1, j + 1, dp);
        }

        // operations
        int insert = 1 + solve(s1, s2, i, j + 1, dp);

        int delete = 1 + solve(s1, s2, i + 1, j, dp);

        int replace = 1 + solve(s1, s2, i + 1, j + 1, dp);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }

    public static void main(String[] args)
    {
        String word1 = "horse";
        String word2 = "ros";

        System.out.println(minDistance(word1, word2));
    }
}