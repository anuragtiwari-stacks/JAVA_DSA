package _20DynamicProgramming;

// LeetCode 279 - Perfect Squares
public class _12PerfectSquares
{
    public static int numSquares(int n)
    {
        int[] dp = new int[n + 1];

        // Step 1: initialize dp with worst case (only 1^2 used)
        for (int i = 0; i <= n; i++)
        {
            dp[i] = i;
        }

        // Step 2: update dp using perfect squares
        for (int j = 2; j * j <= n; j++)
        {
            int square = j * j;
            for (int i = square; i <= n; i++)
            {
                dp[i] = Math.min(dp[i], 1 + dp[i - square]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args)
    {
        int n = 12;
        System.out.println(numSquares(n));
    }
}

/*
==================== DRY RUN ====================

n = 12

Initial dp (using only 1^2):
dp = [0,1,2,3,4,5,6,7,8,9,10,11,12]

Using square = 4:
dp[4]  = min(4, 1 + dp[0])  = 1
dp[5]  = min(5, 1 + dp[1])  = 2
dp[6]  = min(6, 1 + dp[2])  = 3
dp[7]  = min(7, 1 + dp[3])  = 4
dp[8]  = min(8, 1 + dp[4])  = 2
dp[9]  = min(9, 1 + dp[5])  = 3
dp[10] = min(10,1 + dp[6])  = 4
dp[11] = min(11,1 + dp[7])  = 5
dp[12] = min(12,1 + dp[8])  = 3

Using square = 9:
dp[9]  = min(3, 1 + dp[0]) = 1
dp[10] = min(4, 1 + dp[1]) = 2
dp[11] = min(5, 1 + dp[2]) = 3
dp[12] = min(3, 1 + dp[3]) = 3

Final dp:
[0,1,2,3,1,2,3,4,2,1,2,3,3]

Answer:
dp[12] = 3
*/
