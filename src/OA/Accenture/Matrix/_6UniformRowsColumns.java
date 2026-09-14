package OA.Accenture.Matrix;

public class _6UniformRowsColumns
{
    public static int countUniform(String s)
    {
        int n = (int)Math.sqrt(s.length());

        char[][] grid = new char[n][n];

        // Fill the grid
        int k = 0;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                grid[i][j] = s.charAt(k++);
            }
        }

        int count = 0;

        // Check rows
        for(int i = 0; i < n; i++)
        {
            boolean uniform = true;

            for(int j = 1; j < n; j++)
            {
                if(grid[i][j] != grid[i][0])
                {
                    uniform = false;
                    break;
                }
            }

            if(uniform)
            {
                count++;
            }
        }

        // Check columns
        for(int j = 0; j < n; j++)
        {
            boolean uniform = true;

            for(int i = 1; i < n; i++)
            {
                if(grid[i][j] != grid[0][j])
                {
                    uniform = false;
                    break;
                }
            }

            if(uniform)
            {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        String s = "aaaa";

        System.out.println(countUniform(s));
    }
}