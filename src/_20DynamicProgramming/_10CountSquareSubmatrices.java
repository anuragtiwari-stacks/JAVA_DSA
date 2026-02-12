package _20DynamicProgramming;

// LeetCode 1277 - Count Square Submatrices with All Ones
public class _10CountSquareSubmatrices
{
    public static int countSquares(int[][] matrix)
    {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        // Step 1: Fill first column
        for (int i = 0; i < n; i++)
        {
            dp[i][0] = matrix[i][0];
        }

        // Step 2: Fill first row
        for (int j = 0; j < m; j++)
        {
            dp[0][j] = matrix[0][j];
        }

        // Step 3: Fill remaining cells
        for (int i = 1; i < n; i++)
        {
            for (int j = 1; j < m; j++)
            {
                if (matrix[i][j] == 1)
                {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),
                                            dp[i - 1][j - 1]);
                }
            }
        }

        // Step 4: Calculate sum
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                ans += dp[i][j];
            }
        }

        return ans;
    }

    public static void main(String[] args)
    {
        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };

        System.out.println(countSquares(matrix));
    }
}

/*
==================== DRY RUN ====================

Input matrix:
[
 [0, 1, 1, 1],
 [1, 1, 1, 1],
 [0, 1, 1, 1]
]

Step 1: First column
dp =
[
 [0],
 [1],
 [0]
]

Step 2: First row
dp =
[
 [0, 1, 1, 1],
 [1, 0, 0, 0],
 [0, 0, 0, 0]
]

Step 3: Remaining cells

i=1, j=1
dp[1][1] = 1 + min(1,1,0) = 1

i=1, j=2
dp[1][2] = 1 + min(1,1,1) = 2

i=1, j=3
dp[1][3] = 1 + min(2,1,1) = 2

i=2, j=1
dp[2][1] = 1 + min(1,0,1) = 1

i=2, j=2
dp[2][2] = 1 + min(2,1,1) = 2

i=2, j=3
dp[2][3] = 1 + min(2,2,2) = 3

Final dp matrix:
[
 [0, 1, 1, 1],
 [1, 1, 2, 2],
 [0, 1, 2, 3]
]

Step 4: Sum
ans = 15
*/
