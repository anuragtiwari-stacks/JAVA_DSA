package Array_String;

/*
Question:
Given n horizontal bars and m vertical bars forming a grid, find the maximum
square hole area that can be formed. Removed bars are not considered in this
version. Just compute the maximum possible square area from the grid dimensions.

Input:
n = number of horizontal bars
m = number of vertical bars

Output:
Maximum square hole area.
*/

public class _3MaximizeSquareHoleArea
{
    public int maximizeSquareHoleArea(int n, int m)
    {
        int final_n = n + 2;
        int final_m = m + 2;

        int maxVertical = final_n - 1;
        int maxHorizontal = final_m - 1;

        int side = Math.min(maxVertical, maxHorizontal);

        return side * side;
    }

    public static void main(String[] args)
    {
        _3MaximizeSquareHoleArea obj = new _3MaximizeSquareHoleArea();

        int n = 2;
        int m = 3;

        int result = obj.maximizeSquareHoleArea(n, m);
        System.out.println("Maximum Square Hole Area = " + result);
    }
}

/*
Dry Run:

Input:
n = 2
m = 3

final_n = n + 2 = 2 + 2 = 4
final_m = m + 2 = 3 + 2 = 5

maxVertical = final_n - 1 = 4 - 1 = 3
maxHorizontal = final_m - 1 = 5 - 1 = 4

side = min(3, 4) = 3
area = side * side = 3 * 3 = 9

Output:
Maximum Square Hole Area = 9
*/
