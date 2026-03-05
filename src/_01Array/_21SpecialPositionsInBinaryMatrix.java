package _01Array;;

// LeetCode 1582
public class _21SpecialPositionsInBinaryMatrix
{
    public int numSpecial(int[][] mat)
    {
        int r = mat.length;
        int c = mat[0].length;

        int count = 0;

        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                if(mat[i][j] == 1)
                {
                    if(check(mat, i, j))
                    {
                        count = count + 1;
                    }
                }
            }
        }

        return count;
    }

    public boolean check(int[][] mat, int i, int j)
    {
        int r = mat.length;
        int c = mat[0].length;

        // check column
        for(int row = 0; row < r; row++)
        {
            if(row == i) continue;

            if(mat[row][j] == 1)
            {
                return false;
            }
        }

        // check row
        for(int col = 0; col < c; col++)
        {
            if(col == j) continue;

            if(mat[i][col] == 1)
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args)
    {
        _21SpecialPositionsInBinaryMatrix obj = new _21SpecialPositionsInBinaryMatrix();

        int[][] mat =
                {
                        {1,0,0},
                        {0,0,1},
                        {1,0,0}
                };

        int result = obj.numSpecial(mat);

        System.out.println(result);
    }

}

/*
Dry Run:

Input Matrix:
1 0 0
0 0 1
1 0 0

Check (0,0)
Column check → row 1=0, row 2=1 → another 1 found → not special

Check (1,2)
Column check → row 0=0, row 2=0
Row check → col 0=0, col 1=0
No other 1 → special → count = 1

Check (2,0)
Column check → row 0=1 → another 1 found → not special

Return count = 1

Output: 1
*/