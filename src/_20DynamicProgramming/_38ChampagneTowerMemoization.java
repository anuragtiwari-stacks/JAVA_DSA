package _20DynamicProgramming;

import java.util.Arrays;

/*
Leetcode 799 - Champagne Tower
(Recursion + Memoization)
*/

public class _38ChampagneTowerMemoization
{

    static double[][] dp;

    public static double solve(int r, int c, double poured)
    {
        if (r == 0 && c == 0)
        {
            return poured;
        }

        if (c < 0 || c > r)
        {
            return 0;
        }

        if (dp[r][c] != -1)
        {
            return dp[r][c];
        }

        double leftParent = solve(r - 1, c - 1, poured);
        double rightParent = solve(r - 1, c, poured);

        double leftOverflow = 0;
        double rightOverflow = 0;

        if (leftParent > 1)
        {
            leftOverflow = (leftParent - 1) / 2.0;
        }

        if (rightParent > 1)
        {
            rightOverflow = (rightParent - 1) / 2.0;
        }

        dp[r][c] = leftOverflow + rightOverflow;

        return dp[r][c];
    }

    public static double champagneTower(int poured, int query_row, int query_glass)
    {
        dp = new double[query_row + 1][query_row + 1];

        for (double[] row : dp)
        {
            Arrays.fill(row, -1);
        }

        double result = solve(query_row, query_glass, poured);

        if (result > 1.0)
        {
            return 1.0;
        }

        return result;
    }

    public static void main(String[] args)
    {
        int poured = 4;
        int query_row = 2;
        int query_glass = 1;

        double answer = champagneTower(poured, query_row, query_glass);

        System.out.println("Champagne in glass = " + answer);
    }
}


/*
==========================================================
                FULL EXPANDED DRY RUN
==========================================================

INPUT:
poured = 4
query_row = 2
query_glass = 1

DP Table initialized with -1

dp size = [3][3]

----------------------------------------------------------
Call solve(2,1)

Since dp[2][1] == -1 → compute

It depends on:
solve(1,0)
solve(1,1)

----------------------------------------------------------
Compute solve(1,0)

Depends on:
solve(0,-1) = 0
solve(0,0)  = 4 (base case)

Overflow:
(4 - 1) / 2 = 1.5

Store:
dp[1][0] = 1.5

----------------------------------------------------------
Compute solve(1,1)

Depends on:
solve(0,0) = 4
solve(0,1) = 0

Overflow:
(4 - 1) / 2 = 1.5

Store:
dp[1][1] = 1.5

----------------------------------------------------------
Now compute solve(2,1)

leftParent  = 1.5
rightParent = 1.5

Overflow from each:

(1.5 - 1) / 2
= 0.25

Total:
0.25 + 0.25 = 0.5

Store:
dp[2][1] = 0.5

----------------------------------------------------------
If solve(1,0) or solve(1,1) is called again,
value is returned directly from dp.

NO recomputation happens.

----------------------------------------------------------
Final Answer = 0.5

==========================================================
Time Complexity:
O(r²)

Space Complexity:
O(r²) for dp + O(r) recursion stack

==========================================================
*/
