package _20DynamicProgramming;

/*
Leetcode 799 - Champagne Tower
(Pure Recursion - No DP)
*/

public class _38ChampagneTower
{

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

        return leftOverflow + rightOverflow;
    }

    public static double champagneTower(int poured, int query_row, int query_glass)
    {
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

STRUCTURE:

Row 0:              (0,0)

Row 1:        (1,0)        (1,1)

Row 2:    (2,0)     (2,1)      (2,2)

We compute:
solve(2,1)

----------------------------------------------------------
Formula:

solve(r,c) =
    overflow from left parent
  + overflow from right parent

Overflow formula:
If parent <= 1 → 0
If parent > 1  → (parent - 1) / 2

----------------------------------------------------------
EXPAND solve(2,1)

solve(2,1)
    leftParent  = solve(1,0)
    rightParent = solve(1,1)

----------------------------------------------------------
Compute solve(1,0)

solve(1,0)
    leftParent  = solve(0,-1) = 0
    rightParent = solve(0,0)

solve(0,0)
    Base case → return poured = 4

So:
leftParent  = 0
rightParent = 4

Overflow:
leftOverflow  = 0
rightOverflow = (4 - 1) / 2
               = 3 / 2
               = 1.5

So:
solve(1,0) = 1.5

----------------------------------------------------------
Compute solve(1,1)

solve(1,1)
    leftParent  = solve(0,0) = 4
    rightParent = solve(0,1) = 0

Overflow:
leftOverflow  = (4 - 1) / 2
               = 1.5
rightOverflow = 0

So:
solve(1,1) = 1.5

----------------------------------------------------------
Now compute solve(2,1)

leftParent  = 1.5
rightParent = 1.5

Overflow from each:

(1.5 - 1) / 2
= 0.5 / 2
= 0.25

Total:
0.25 + 0.25 = 0.5

----------------------------------------------------------
Final Check:

Since 0.5 < 1
Final answer = 0.5

==========================================================

FINAL OUTPUT:
Champagne in glass = 0.5

==========================================================
Time Complexity:
Exponential (Tree Recursion)

Space Complexity:
O(r) recursion stack

==========================================================
*/
