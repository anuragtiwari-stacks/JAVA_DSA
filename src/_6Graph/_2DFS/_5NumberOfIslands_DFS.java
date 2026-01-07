package _6Graph._2DFS;

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

public class _5NumberOfIslands_DFS
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
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    static void dfs(char[][] grid, boolean[][] visited, int row, int col)
    {
        int m = grid.length;
        int n = grid[0].length;

        visited[row][col] = true;

        // Check Top
        if (row > 0)
        {
            if (grid[row - 1][col] == '1')
            {
                if (!visited[row - 1][col])
                {
                    dfs(grid, visited, row - 1, col);
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
                    dfs(grid, visited, row + 1, col);
                }
            }
        }

        // Check Left
        if (col > 0)
        {
            if (grid[row][col - 1] == '1')
            {
                if (!visited[row][col - 1])
                {
                    dfs(grid, visited, row, col - 1);
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
                    dfs(grid, visited, row, col + 1);
                }
            }
        }
    }
}

/*
🔍 Concept:

- Each '1' in the grid is a land cell.
- DFS is used to explore all connected land cells from a starting unvisited cell.
- Check all four directions manually like in BFS: top, bottom, left, right.
- Recursively call DFS for each valid unvisited neighbor.
- Each DFS call that starts from a new land cell = 1 island.

🧠 Graph Intuition:

    Grid:

    1 1 0 0 0
    1 1 0 0 0
    0 0 1 0 0
    0 0 0 1 1

    ➤ Island 1: top-left 1's
    ➤ Island 2: center (2,2)
    ➤ Island 3: bottom-right (3,3) & (3,4)

✅ Output: 3
*/
