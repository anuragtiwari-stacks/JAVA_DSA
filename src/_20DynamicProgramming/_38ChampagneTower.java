package _20DynamicProgramming;

/*
Leetcode 799 - Champagne Tower
*/

public class ChampagneTower_799
{

    public static void main(String[] args)
    {
        ChampagneTower_799 obj = new ChampagneTower_799();

        int poured = 4;
        int query_row = 2;
        int query_glass = 1;

        double ans = obj.champagneTower(poured, query_row, query_glass);

        System.out.println("Poured: " + poured);
        System.out.println("Query Row: " + query_row);
        System.out.println("Query Glass: " + query_glass);
        System.out.println("Answer: " + ans);
    }

    public double champagneTower(int poured, int query_row, int query_glass)
    {
        double result = solve(query_row, query_glass, poured);

        if (result > 1.0)
        {
            return 1.0;
        }

        return result;
    }

    public double solve(int r, int c, double poured)
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
}


/*
==========================
Dry Run
==========================

Input:
poured = 4
query_row = 2
query_glass = 1

Row 0:              (0,0)
Row 1:        (1,0)      (1,1)
Row 2:    (2,0)    (2,1)    (2,2)

Step 1:
solve(2,1)

It depends on:
solve(1,0) and solve(1,1)

solve(1,0):
    leftParent  = solve(0,-1) = 0
    rightParent = solve(0,0)  = 4

    rightOverflow = (4 - 1) / 2
                   = 3 / 2
                   = 1.5

    solve(1,0) = 1.5

solve(1,1):
    leftParent  = solve(0,0) = 4
    rightParent = solve(0,1) = 0

    leftOverflow = (4 - 1) / 2
                 = 1.5

    solve(1,1) = 1.5

Now solve(2,1):

leftParent  = 1.5
rightParent = 1.5

Overflow from each:

(1.5 - 1) / 2
= 0.5 / 2
= 0.25

Total:

0.25 + 0.25 = 0.5

Final Answer = 0.5

Time Complexity:
Exponential (Tree Recursion)

==========================
*/
