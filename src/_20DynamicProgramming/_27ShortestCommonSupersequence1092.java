package _20DynamicProgramming;
// LeetCode 1092

public class _27ShortestCommonSupersequence1092
{
    public static String shortestCommonSupersequence(String s1, String s2)
    {
        String lcs = getLCS(s1, s2);

        int i = 0;
        int j = 0;
        int k = 0;

        StringBuilder sb = new StringBuilder();

        // Traverse LCS
        while (k < lcs.length())
        {
            char ch = lcs.charAt(k);

            // Add extra chars from s1
            while (s1.charAt(i) != ch)
            {
                sb.append(s1.charAt(i));
                i++;
            }

            // Add extra chars from s2
            while (s2.charAt(j) != ch)
            {
                sb.append(s2.charAt(j));
                j++;
            }

            // Add common char once
            sb.append(ch);

            i++;
            j++;
            k++;
        }

        // Add remaining chars from s1
        while (i < s1.length())
        {
            sb.append(s1.charAt(i));
            i++;
        }

        // Add remaining chars from s2
        while (j < s2.length())
        {
            sb.append(s2.charAt(j));
            j++;
        }

        return sb.toString();
    }

    public static String getLCS(String s1, String s2)
    {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Build DP Table
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i - 1][j],
                            dp[i][j - 1]);
                }
            }
        }

        // Backtrack to get LCS
        int i = n;
        int j = m;

        String lcs = "";

        while (i > 0 && j > 0)
        {
            if (s1.charAt(i - 1) == s2.charAt(j - 1))
            {
                lcs = s1.charAt(i - 1) + lcs;

                i--;
                j--;
            }
            else if (dp[i - 1][j] > dp[i][j - 1])
            {
                i--;
            }
            else
            {
                j--;
            }
        }

        return lcs;
    }

    public static void main(String[] args)
    {
        String s1 = "abac";
        String s2 = "cab";

        System.out.println(shortestCommonSupersequence(s1, s2));
    }
}