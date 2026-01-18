package Array_String;

// LeetCode 1895: Largest Magic Square
public class _4LargestMagicSquare
{
    public int largestMagicSquare(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;

        for (int len = Math.min(m, n); len >= 2; len--)
        {
            for (int i = 0; i + len <= m; i++)
            {
                for (int j = 0; j + len <= n; j++)
                {
                    if (check(grid, i, j, len))
                    {
                        return len;
                    }
                }
            }
        }

        return 1;
    }

    private boolean check(int[][] g, int r, int c, int len)
    {
        int target = 0;
        for (int y = 0; y < len; y++)
        {
            target = target + g[r][c + y];
        }


        //Check all row
        for (int x = r; x < r + len; x++)
        {
            int sum = 0;
            for (int y = c; y < c + len; y++)
            {
                sum = sum + g[x][y];
            }
            if (sum != target)
            {
                return false;
            }
        }

        //Check all column
        for (int y = c; y < c + len; y++)
        {
            int sum = 0;
            for (int x = r; x < r + len; x++)
            {
                sum = sum + g[x][y];
            }
            if (sum != target)
            {
                return false;
            }
        }

        // check primary diagonal
        int d1 = 0;
        for (int k = 0; k < len; k++)
        {
            d1 = d1 + g[r + k][c + k];
        }
        if (d1 != target)
        {
            return false;
        }

        // check secondary diagonal
        int d2 = 0;
        for (int k = 0; k < len; k++)
        {
            d2 = d2 + g[r + k][c + (len - 1 - k)];
        }
        if (d2 != target)
        {
            return false;
        }

        return true;

    }

    public static void main(String[] args)
    {
        int[][] grid =
                {
                        {7,1,4,5,6},
                        {2,5,1,6,4},
                        {1,5,4,3,2},
                        {1,2,7,3,4}
                };

        _4LargestMagicSquare obj = new _4LargestMagicSquare();
        System.out.println(obj.largestMagicSquare(grid));
    }
}


/*
---------------- DRY RUN (Example) ----------------

Input grid:
7  1  4  5  6
2  5  1  6  4
1  5  4  3  2
6  4  4  1  3
1  3  3  2  4

m = 5, n = 5
largest try len = 5 (fails)
len = 4 (fails)
len = 3 -> scan i=0,j=0:

Square (3x3 starting r=0,c=0):
7 1 4
2 5 1
1 5 4

target = 7+1+4 = 12

Row checks:
r0: 7+1+4 = 12 ✓
r1: 2+5+1 = 8 ✗ -> fails, continue next square

Eventually finds:
r=1,c=1 (3x3):
5 1 6
5 4 3
4 1 3

target = 5+1+6 = 12

Row sums: 12,12,12 ✓
Col sums: 12,12,12 ✓
diag1: 5+4+3 = 12 ✓
diag2: 6+4+4 = 14 ✗ -> fails

Finally finds valid square for len=3 at (2,1)

Answer returned = 3

--------------------------------------------------
*/
