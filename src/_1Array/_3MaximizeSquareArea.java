// Not a LeetCode Problem - Maximize Square Area

package _1Array;

public class _3MaximizeSquareArea
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
        _3MaximizeSquareArea obj = new _3MaximizeSquareArea();
        int n = 2;
        int m = 3;
        int result = obj.maximizeSquareHoleArea(n, m);
        System.out.println(result);
    }
}

/*
==================== DRY RUN ====================

Input:
n = 2
m = 3

final_n = n + 2 = 2 + 2 = 4
final_m = m + 2 = 3 + 2 = 5

maxVertical = final_n - 1 = 4 - 1 = 3
maxHorizontal = final_m - 1 = 5 - 1 = 4

side = min(3, 4) = 3

area = side * side = 3 * 3 = 9

Console Output:
9

=================================================
*/
