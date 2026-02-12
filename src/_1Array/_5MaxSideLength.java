package _1Array;

// LeetCode 1292: Maximum Side Length of a Square with Sum <= Threshold
public class _5MaxSideLength
{
    public int maxSideLength(int[][] mat, int threshold)
    {
        int m = mat.length;
        int n = mat[0].length;

        for (int len = Math.min(m, n); len >= 1; len--)
        {
            for (int i = 0; i + len <= m; i++)
            {
                for (int j = 0; j + len <= n; j++)
                {
                    if (check(mat, i, j, len, threshold))
                    {
                        return len;
                    }
                }
            }
        }

        return 0;
    }

    private boolean check(int[][] g, int r, int c, int len, int threshold)
    {
        int sum = 0;

        for (int x = r; x < r + len; x++)
        {
            for (int y = c; y < c + len; y++)
            {
                sum = sum + g[x][y];

                if (sum > threshold)   // early exit
                {
                    return false;
                }
            }
        }

        if (sum <= threshold)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main(String[] args)
    {
        int[][] mat =
                {
                        {1, 1, 3, 2, 4, 3, 2},
                        {1, 1, 3, 2, 4, 3, 2},
                        {1, 1, 3, 2, 4, 3, 2}
                };

        int threshold = 4;

        _5MaxSideLength obj = new _5MaxSideLength();
        System.out.println(obj.maxSideLength(mat, threshold));
    }
}


/*
---------------- DRY RUN (Example) ----------------

Input:
mat =
1 1 3 2 4 3 2
1 1 3 2 4 3 2
1 1 3 2 4 3 2

threshold = 4

m = 3, n = 7
max possible square side = min(3,7) = 3

Check len = 3:
  squares start at (0,0), (0,1), (0,2), ..., (0,4)
  For (0,0):
      sum = 1+1+3 + 1+1+3 + 1+1+3 = 15 > 4 -> fails
  All other positions for len=3 also exceed quickly
  No valid 3x3 found

Check len = 2:
  For (0,0):
      sum = 1+1 + 1+1 = 4 <= 4 -> valid
  Therefore answer = 2 (stop because we go from largest to smallest)

Output: 2

---------------------------------------------------
*/
