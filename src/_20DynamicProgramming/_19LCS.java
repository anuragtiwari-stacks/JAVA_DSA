package _20DynamicProgramming;

public class _19LCS
{
    public static int longestCommonSubsequence(String text1, String text2)
    {
        return solve(text1, text2, text1.length(), text2.length());
    }

    private static int solve(String s1, String s2, int i, int j)
    {
        if (i == 0 || j == 0)
        {
            return 0;
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1))
        {
            return 1 + solve(s1, s2, i - 1, j - 1);
        }

        return Math.max(
                solve(s1, s2, i - 1, j),
                solve(s1, s2, i, j - 1)
        );
    }

    public static void main(String[] args)
    {
        System.out.println(
                longestCommonSubsequence("abcde", "ace")
        );
    }
}
