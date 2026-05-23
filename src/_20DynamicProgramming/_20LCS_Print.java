package _20DynamicProgramming;

// Print Longest Common Subsequence
public class _20LCS_Print
{
    public static String getLCS(String text1, String text2)
    {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Build DP Table
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
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Backtracking to get LCS
        int i = n;
        int j = m;

        String ans = "";

        while (i > 0 && j > 0)
        {
            // Character matched
            if (text1.charAt(i - 1) == text2.charAt(j - 1))
            {
                ans = text1.charAt(i - 1) + ans;

                i--;
                j--;
            }

            // Move towards larger value
            else if (dp[i - 1][j] > dp[i][j - 1])
            {
                i--;
            }
            else
            {
                j--;
            }
        }

        return ans;
    }

    public static void main(String[] args)
    {
        String text1 = "abcde";
        String text2 = "ace";

        System.out.println(getLCS(text1, text2));
    }
}