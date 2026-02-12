package _1Array;

import java.util.*;

/*
LeetCode 2943: Maximize Area of Square Hole in Grid

Question:
You are given n horizontal bars (numbered 1 to n) and m vertical bars (numbered 1 to m).
Some horizontal bars and some vertical bars are removed. When k consecutive horizontal
bars and k consecutive vertical bars are removed, they form a square hole of side (k+1).

Task:
Given:
n = number of horizontal bars
m = number of vertical bars
hBars[] = removed horizontal bars
vBars[] = removed vertical bars

Return:
Maximum possible square hole area = side * side
*/

public class _3MaximizeSquareHoleArea
{
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars)
    {
        // Step 1: Sort both arrays of removed bars
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        // Step 2: Find longest consecutive removed horizontal bars
        int maxConsecutiveH = 1;
        int currH = 1;

        for (int i = 1; i < hBars.length; i++)
        {
            if (hBars[i] - hBars[i - 1] == 1)
            {
                currH++;
            }
            else
            {
                currH = 1;
            }
            maxConsecutiveH = Math.max(maxConsecutiveH, currH);
        }

        // Step 3: Find longest consecutive removed vertical bars
        int maxConsecutiveV = 1;
        int currV = 1;

        for (int i = 1; i < vBars.length; i++)
        {
            if (vBars[i] - vBars[i - 1] == 1)
            {
                currV++;
            }
            else
            {
                currV = 1;
            }
            maxConsecutiveV = Math.max(maxConsecutiveV, currV);
        }

        // Step 4: Side length = minimum of (max consecutive horizontal + 1) and (max consecutive vertical + 1)
        int side = Math.min(maxConsecutiveH + 1, maxConsecutiveV + 1);

        // Step 5: Area = side * side
        return side * side;
    }

    public static void main(String[] args)
    {
        _3MaximizeSquareHoleArea obj = new _3MaximizeSquareHoleArea();

        int n = 5;
        int m = 6;
        int[] hBars = {2, 3, 4};
        int[] vBars = {1, 2};

        int result = obj.maximizeSquareHoleArea(n, m, hBars, vBars);
        System.out.println("Maximum Square Hole Area = " + result);
    }
}

/*
Dry Run Example:

Input:
n = 5, m = 6
hBars = {2, 3, 4}
vBars = {1, 2}

Step 1: sort(hBars) => {2, 3, 4}
Step 2: sort(vBars) => {1, 2}

Find longest consecutive in hBars:
2 -> 3 consecutive -> count = 2
3 -> 4 consecutive -> count = 3
maxConsecutiveH = 3

Find longest consecutive in vBars:
1 -> 2 consecutive -> count = 2
maxConsecutiveV = 2

Compute side:
side = min(3+1, 2+1) = min(4, 3) = 3

Compute area:
area = 3 * 3 = 9

Output:
Maximum Square Hole Area = 9
*/
