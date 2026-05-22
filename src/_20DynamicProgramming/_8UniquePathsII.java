package _20DynamicProgramming;

// LeetCode 63 - Unique Paths II
public class _8UniquePathsII
{
    public static int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        // starting cell
        if(obstacleGrid[0][0]==0)
        {
            dp[0][0] = 1;
        }
        else
        {
            dp[0][0] = 0;
        }

        // fill first row
        for (int j = 1; j < n; j++)
        {
            if (obstacleGrid[0][j] == 0)
            {
                dp[0][j] = dp[0][j - 1];
            }
            else
            {
                dp[0][j] = 0;
            }
        }

        // fill first column
        for (int i = 1; i < m; i++)
        {
            if (obstacleGrid[i][0] == 0)
            {
                dp[i][0] = dp[i - 1][0];
            }
            else
            {
                dp[i][0] = 0;
            }
        }

        // fill remaining cells
        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                if (obstacleGrid[i][j] == 0)
                {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
                else
                {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args)
    {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}

/*
==================== DRY RUN ====================

Input:
obstacleGrid =
[
 [0, 0, 0],
 [0, 1, 0],
 [0, 0, 0]
]

dp[0][0] = 1

First column:
dp[1][0] = 1
dp[2][0] = 1

First row:
dp[0][1] = 1
dp[0][2] = 1

Remaining cells:

i=1, j=1
obstacleGrid[1][1] = 1 → dp[1][1] = 0

i=1, j=2
dp[1][2] = dp[0][2] + dp[1][1]
         = 1 + 0
         = 1

i=2, j=1
dp[2][1] = dp[1][1] + dp[2][0]
         = 0 + 1
         = 1

i=2, j=2
dp[2][2] = dp[1][2] + dp[2][1]
         = 1 + 1
         = 2

Final dp matrix:
[
 [1, 1, 1],
 [1, 0, 1],
 [1, 1, 2]
]

Output:
2
*/
