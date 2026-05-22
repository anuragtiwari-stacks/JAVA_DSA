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
                    // single  + pair
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

Final dp array:
[1, 1, 2, 4]
*/

/*
Dry Run for n = 3

Friends:
1 2 3

Formula:
dp[n] = dp[n - 1] + (n - 1) * dp[n - 2]

-----------------------------------------

Step 1:
Friend 3 stays single

Remaining friends:
1 2

Ways for 1 and 2:
(1)(2)
(12)

Now add single 3:

(1)(2)(3)
(12)(3)

Total ways = 2

This is:
dp[2]

-----------------------------------------

Step 2:
Friend 3 pairs up

Friend 3 can pair with:
1 or 2

Case A:
(31)(2)

Case B:
(32)(1)

Total ways = 2

This is:
(3 - 1) * dp[1]
= 2 * 1
= 2

-----------------------------------------

Final Answer:

dp[3]
= dp[2] + (3 - 1) * dp[1]
= 2 + 2
= 4

Final Ways:

(1)(2)(3)
(12)(3)
(31)(2)
(32)(1)
*/
