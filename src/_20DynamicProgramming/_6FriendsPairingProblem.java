package _20DynamicProgramming;

// Friends Pairing Problem
public class _6FriendsPairingProblem
{
    public static int countWays(int n)
    {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++)
        {
            dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args)
    {
        int n = 4;
        System.out.println(countWays(n));
    }
}

/*
==================== DRY RUN ====================

Problem:
n friends → each friend can stay single or pair up with one other friend

Input:
n = 4

Base:
dp[0] = 1
dp[1] = 1
dp[2] = 2

i = 3
dp[3] = dp[2] + (3 - 1) * dp[1]
      = 2 + 2 * 1
      = 4

i = 4
dp[4] = dp[3] + (4 - 1) * dp[2]
      = 4 + 3 * 2
      = 10

Final dp array:
[1, 1, 2, 4, 10]

Output:
10
*/

/*
Input: n = 3
Output: 4

Explanation:
1) (1) (2) (3)
2) (1,2) (3)
3) (1,3) (2)
4) (2,3) (1)
*/