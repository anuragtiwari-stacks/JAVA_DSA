package _20DynamicProgramming;

// LeetCode 62 - Unique Paths
public class _7UniquePaths
{
    public static int uniquePaths(int m, int n)
    {
        int[][] dp = new int[m][n];

        // base case: first row & first column
        for (int i = 0; i < m; i++)
        {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++)
        {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args)
    {
        int m = 3;
        int n = 7;
        System.out.println(uniquePaths(m, n));
    }
}

/*
==================== DRY RUN ====================

Input:
m = 3, n = 7

Grid size = 3 x 7

First row:
[1 1 1 1 1 1 1]

First column:
[1]
[1]
[1]

Now fill remaining cells:

dp[1][1] = dp[0][1] + dp[1][0] = 1 + 1 = 2
dp[1][2] = dp[0][2] + dp[1][1] = 1 + 2 = 3
dp[1][3] = dp[0][3] + dp[1][2] = 1 + 3 = 4
dp[1][4] = dp[0][4] + dp[1][3] = 1 + 4 = 5
dp[1][5] = dp[0][5] + dp[1][4] = 1 + 5 = 6
dp[1][6] = dp[0][6] + dp[1][5] = 1 + 6 = 7

dp[2][1] = dp[1][1] + dp[2][0] = 2 + 1 = 3
dp[2][2] = dp[1][2] + dp[2][1] = 3 + 3 = 6
dp[2][3] = dp[1][3] + dp[2][2] = 4 + 6 = 10
dp[2][4] = dp[1][4] + dp[2][3] = 5 + 10 = 15
dp[2][5] = dp[1][5] + dp[2][4] = 6 + 15 = 21
dp[2][6] = dp[1][6] + dp[2][5] = 7 + 21 = 28

Final dp matrix:
[
 [1, 1, 1, 1, 1, 1, 1],
 [1, 2, 3, 4, 5, 6, 7],
 [1, 3, 6, 10, 15, 21, 28]
]

Output:
28
*/
