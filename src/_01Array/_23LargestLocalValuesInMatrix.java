package _01Array;

public class _23LargestLocalValuesInMatrix
{
    public static int[][] largestLocal(int[][] grid)
    {
        int n = grid.length;

        int[][] ans = new int[n - 2][n - 2];

        for(int i = 0; i < n - 2; i++)
        {
            for(int j = 0; j < n - 2; j++)
            {
                int max = 0;

                // Traverse 3x3 matrix
                for(int r = i; r < i + 3; r++)
                {
                    for(int c = j; c < j + 3; c++)
                    {
                        max = Math.max(max, grid[r][c]);
                    }
                }

                ans[i][j] = max;
            }
        }

        return ans;
    }

    public static void main(String[] args)
    {
        int[][] grid =
                {
                        {9,9,8,1},
                        {5,6,2,6},
                        {8,2,6,4},
                        {6,2,2,2}
                };

        int[][] ans = largestLocal(grid);

        for(int i = 0; i < ans.length; i++)
        {
            for(int j = 0; j < ans[0].length; j++)
            {
                System.out.print(ans[i][j] + " ");
            }

            System.out.println();
        }
    }
}