package _17DynamicProgramming;

public class _31LongestCommonSubstring
{
    public static int longestCommonSubstring(String s1, String s2)
    {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        int maxLen = 0;
        int endIndex = 0;

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if(dp[i][j] > maxLen)
                    {
                        maxLen = dp[i][j];
                        endIndex = i;
                    }
                }
                else
                {
                    dp[i][j] = 0;
                }
            }
        }

        if(maxLen == 0)
        {
            return 0;
        }

        String substring = s1.substring(endIndex - maxLen, endIndex);
        System.out.println("Longest Common Substring: " + substring);
        return maxLen;
    }

    public static void main(String[] args)
    {
        String s1 = "abcdef";
        String s2 = "bcadef";

        int length = longestCommonSubstring(s1, s2);
        System.out.println("Length = " + length);
    }
}

/*
------------------------- DRY RUN -------------------------
Input:
s1 = "abcdef"
s2 = "bcadef"

We build dp[i][j] where:
dp[i][j] = length of longest common suffix of s1[0..i-1], s2[0..j-1]

Index mapping:
s1: a(0) b(1) c(2) d(3) e(4) f(5)
s2: b(0) c(1) a(2) d(3) e(4) f(5)

DP Table (with first row & first column = 0):

       0  b  c  a  d  e  f
     -----------------------
0 |    0  0  0  0  0  0  0
a |    0  0  0  1  0  0  0
b |    0  1  0  0  0  0  0
c |    0  0  2  0  0  0  0
d |    0  0  0  0  1  0  0
e |    0  0  0  0  0  2  0
f |    0  0  0  0  0  0  3

Matches found:
- b == b → dp[2][1] = 1
- c == c → dp[3][2] = dp[2][1] + 1 = 2  → "bc"
- a == a → dp[1][3] = 1               → "a"
- d == d → dp[4][4] = 1               → "d"
- e == e → dp[5][5] = dp[4][4] + 1 = 2 → "de"
- f == f → dp[6][6] = dp[5][5] + 1 = 3 → "def"

Final longest common substring length = 3
Substring = "def"

------------------------- OUTPUT --------------------------
Longest Common Substring: def
Length = 3
-----------------------------------------------------------
*/
