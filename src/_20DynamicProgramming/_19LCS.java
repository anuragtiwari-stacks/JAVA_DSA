package _20DynamicProgramming;

// LeetCode 1143 - Longest Common Subsequence (Recursion)

public class _19LCS
{
    public static int solve(String s1, String s2, int i, int j)
    {
        // base case
        if (i == 0 || j == 0)
        {
            return 0;
        }

        // characters match
        if (s1.charAt(i - 1) == s2.charAt(j - 1))
        {
            return 1 + solve(s1, s2, i - 1, j - 1);
        }

        // characters do not match
        return Math.max(solve(s1, s2, i - 1, j), solve(s1, s2, i, j - 1));
    }

    public static void main(String[] args)
    {
        String text1 = "abcde";
        String text2 = "ace";

        int ans = solve(text1, text2, text1.length(), text2.length());

        System.out.println(ans);
    }
}


/*
public class _19LCS_Forward
{
    public static int solve(String s1, String s2, int i, int j)
    {
        // base case
        if (i == s1.length() || j == s2.length())
        {
            return 0;
        }

        // characters match
        if (s1.charAt(i) == s2.charAt(j))
        {
            return 1 + solve(s1, s2, i + 1, j + 1);
        }

        // skip one character
        return Math.max(solve(s1, s2, i + 1, j),solve(s1, s2, i, j + 1));
    }
}
*/