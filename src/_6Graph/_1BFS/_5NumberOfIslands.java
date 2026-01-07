package _6Graph._1BFS;

import java.util.*;

class Pair
{
    int row;
    int col;

    Pair(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
}

public class _5NumberOfIslands
{

    public static void main(String[] args)
    {
        /*
            🔗 Input Grid:

            [
              ["1","1","0","0","0"],
              ["1","1","0","0","0"],
              ["0","0","1","0","0"],
              ["0","0","0","1","1"]
            ]

            ✅ Output: 3
         */

        char[][] grid =
                {
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                };

        int result = numIslands(grid);
        System.out.println("Number of islands: " + result);
    }

    static int numIslands(char[][] grid)
    {
        if (grid == null || grid.length == 0)
        {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == '1' && !visited[i][j])
                {
                    bfs(grid, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    static void bfs(char[][] grid, boolean[][] visited, int startRow, int startCol)
    {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startRow, startCol));
        visited[startRow][startCol] = true;

        while (!q.isEmpty())
        {
            Pair current = q.remove();
            int row = current.row;
            int col = current.col;

            // Check Top
            if (row > 0)
            {
                if (grid[row - 1][col] == '1')
                {
                    if (!visited[row - 1][col])
                    {
                        q.add(new Pair(row - 1, col));
                        visited[row - 1][col] = true;
                    }
                }
            }

            // Check Bottom
            if (row + 1 < m)
            {
                if (grid[row + 1][col] == '1')
                {
                    if (!visited[row + 1][col])
                    {
                        q.add(new Pair(row + 1, col));
                        visited[row + 1][col] = true;
                    }
                }
            }

            // Check Left
            if (col  > 0)
            {
                if (grid[row][col - 1] == '1')
                {
                    if (!visited[row][col - 1])
                    {
                        q.add(new Pair(row, col - 1));
                        visited[row][col - 1] = true;
                    }
                }
            }

            // Check Right
            if (col + 1 < n)
            {
                if (grid[row][col + 1] == '1')
                {
                    if (!visited[row][col + 1])
                    {
                        q.add(new Pair(row, col + 1));
                        visited[row][col + 1] = true;
                    }
                }
            }
        }
    }
}
