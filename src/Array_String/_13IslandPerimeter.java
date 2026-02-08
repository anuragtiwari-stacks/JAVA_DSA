package Array_String;

// LeetCode 463
// Island Perimeter

public class _13IslandPerimeter
{
    public static int islandPerimeter(int[][] grid)
    {
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(grid[i][j] == 1)
                {
                    // Each land cell contributes 4 initially
                    perimeter += 4;

                    // Check top cell
                    if(i > 0 && grid[i - 1][j] == 1)
                    {
                        perimeter -= 2;
                    }

                    // Check left cell
                    if(j > 0 && grid[i][j - 1] == 1)
                    {
                        perimeter -= 2;
                    }
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args)
    {
        int[][] grid = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };

        System.out.println(islandPerimeter(grid)); // 16
    }
}

/*
Logic:
- Each land cell has 4 sides initially.
- When two land cells are adjacent, they share one side.
- A shared side is counted twice (once by each cell),
  so we subtract 2 for every shared edge.
- We only check TOP and LEFT neighbors to avoid double counting.

Why only TOP and LEFT?
- Grid is traversed row by row, left to right.
- TOP and LEFT cells are already processed.
- DOWN and RIGHT cells will be processed later.
- This ensures each shared edge is subtracted exactly once.

Dry Run:

Input Grid:
[
  [0,1,0,0],
  [1,1,1,0],
  [0,1,0,0],
  [1,1,0,0]
]

Step-by-step:
- Cell (0,1) → +4 → perimeter = 4
- Cell (1,0) → +4 → perimeter = 8
- Cell (1,1) → +4 −2 (top) −2 (left) → perimeter = 8
- Cell (1,2) → +4 −2 (left) → perimeter = 10
- Cell (2,1) → +4 −2 (top) → perimeter = 12
- Cell (3,0) → +4 → perimeter = 16
- Cell (3,1) → +4 −2 (top) −2 (left) → perimeter = 16

Output:
16
*/
