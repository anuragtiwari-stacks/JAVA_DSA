package _01Array;
// 3933
public class _24LargestLocalValuesII
{
    public static int countLocalMaximums(int[][] matrix)
    {
        int n = matrix.length;
        int m = matrix[0].length;

        int count = 0;

        for(int row = 0; row < n; row++)
        {
            for(int col = 0; col < m; col++)
            {
                int x = matrix[row][col];

                if(x == 0)
                {
                    continue;
                }

                boolean isLocalMax = true;

                for(int i = row - x; i <= row + x && isLocalMax; i++)
                {
                    for(int j = col - x; j <= col + x; j++)
                    {
                        // Outside matrix
                        if(i < 0 || i >= n || j < 0 || j >= m)
                        {
                            continue;
                        }

                        // Ignore corners
                        if(Math.abs(i - row) == x && Math.abs(j - col) == x)
                        {
                            continue;
                        }

                        // Greater value found
                        if(matrix[i][j] > x)
                        {
                            isLocalMax = false;
                            break;
                        }
                    }
                }

                if(isLocalMax)
                {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        int[][] matrix =
                {
                        {0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0},
                        {0,0,0,2,0,0,0},
                        {0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0}
                };

        System.out.println(countLocalMaximums(matrix));
    }
}