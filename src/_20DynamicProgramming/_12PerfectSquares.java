package _20DynamicProgramming;

// LeetCode 279 - Perfect Squares

public class _12PerfectSquares
{
    public static int numSquares(int n)
    {
        int[] dp = new int[n + 1];

        // Worst case:
        // Every number made using only 1's
        for(int i = 0; i <= n; i++)
        {
            dp[i] = i;
        }

        dp[0] = 0;

        // Build DP
        for(int i = 1; i <= n; i++)
        {
            // Try every perfect square
            for(int j = 1; j * j <= i; j++)
            {
                dp[i] = Math.min(dp[i],dp[i - (j * j)] + 1);
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
Dry Run for n = 12

------------------------------------------------

Initial DP Array:

for(int i = 0; i <= n; i++)
{
    dp[i] = i;
}

So:

Index:
0 1 2 3 4 5 6 7 8 9 10 11 12

DP:
0 1 2 3 4 5 6 7 8 9 10 11 12

Meaning:
Worst case:
Use only 1's

Example:
12 = 1+1+1+1+1+1+1+1+1+1+1+1

------------------------------------------------

i = 1

Squares possible:
1

dp[1]
= min(dp[1], dp[1 - 1] + 1)
= min(1, dp[0] + 1)
= min(1, 0 + 1)
= 1

DP:
0 1 2 3 4 5 6 7 8 9 10 11 12

------------------------------------------------

i = 2

Squares possible:
1

dp[2]
= min(2, dp[1] + 1)
= min(2, 1 + 1)
= 2

DP:
0 1 2 3 4 5 6 7 8 9 10 11 12

------------------------------------------------

i = 3

Squares possible:
1

dp[3]
= min(3, dp[2] + 1)
= min(3, 2 + 1)
= 3

DP:
0 1 2 3 4 5 6 7 8 9 10 11 12

------------------------------------------------

i = 4

Squares possible:
1, 4

Using 1:
dp[4]
= min(4, dp[3] + 1)
= min(4, 3 + 1)
= 4

Using 4:
dp[4]
= min(4, dp[0] + 1)
= min(4, 0 + 1)
= 1

DP:
0 1 2 3 1 5 6 7 8 9 10 11 12

------------------------------------------------

i = 5

Squares:
1, 4

Using 1:
dp[5]
= min(5, dp[4] + 1)
= min(5, 1 + 1)
= 2

Using 4:
dp[5]
= min(2, dp[1] + 1)
= min(2, 1 + 1)
= 2

DP:
0 1 2 3 1 2 6 7 8 9 10 11 12

------------------------------------------------

i = 6

Squares:
1, 4

Using 1:
dp[6]
= min(6, dp[5] + 1)
= 3

Using 4:
dp[6]
= min(3, dp[2] + 1)
= 3

DP:
0 1 2 3 1 2 3 7 8 9 10 11 12

------------------------------------------------

i = 7

Squares:
1, 4

Using 1:
dp[7]
= min(7, dp[6] + 1)
= 4

Using 4:
dp[7]
= min(4, dp[3] + 1)
= 4

DP:
0 1 2 3 1 2 3 4 8 9 10 11 12

------------------------------------------------

i = 8

Squares:
1, 4

Using 1:
dp[8]
= min(8, dp[7] + 1)
= 5

Using 4:
dp[8]
= min(5, dp[4] + 1)
= min(5, 1 + 1)
= 2

DP:
0 1 2 3 1 2 3 4 2 9 10 11 12

------------------------------------------------

i = 9

Squares:
1, 4, 9

Using 1:
dp[9]
= min(9, dp[8] + 1)
= 3

Using 4:
dp[9]
= min(3, dp[5] + 1)
= 3

Using 9:
dp[9]
= min(3, dp[0] + 1)
= 1

DP:
0 1 2 3 1 2 3 4 2 1 10 11 12

------------------------------------------------

i = 10

Squares:
1, 4, 9

Using 1:
dp[10]
= min(10, dp[9] + 1)
= 2

Using 4:
dp[10]
= min(2, dp[6] + 1)
= 2

Using 9:
dp[10]
= min(2, dp[1] + 1)
= 2

DP:
0 1 2 3 1 2 3 4 2 1 2 11 12

------------------------------------------------

i = 11

Squares:
1, 4, 9

Using 1:
dp[11]
= min(11, dp[10] + 1)
= 3

Using 4:
dp[11]
= min(3, dp[7] + 1)
= 3

Using 9:
dp[11]
= min(3, dp[2] + 1)
= 3

DP:
0 1 2 3 1 2 3 4 2 1 2 3 12

------------------------------------------------

i = 12

Squares:
1, 4, 9

Using 1:
dp[12]
= min(12, dp[11] + 1)
= 4

Using 4:
dp[12]
= min(4, dp[8] + 1)
= min(4, 2 + 1)
= 3

Using 9:
dp[12]
= min(3, dp[3] + 1)
= min(3, 3 + 1)
= 3

Final DP:
0 1 2 3 1 2 3 4 2 1 2 3 3

------------------------------------------------

Final Answer:

dp[12] = 3

12 = 4 + 4 + 4
*/