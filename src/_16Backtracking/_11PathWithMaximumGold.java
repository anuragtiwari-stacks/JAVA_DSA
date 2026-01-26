package _16Backtracking;

// LeetCode 1219: Path with Maximum Gold
import java.util.*;

public class _11PathWithMaximumGold
{
    int maxGold = 0;

    public int getMaximumGold(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] > 0)
                {
                    backtrack(grid, i, j, 0);
                }
            }
        }

        return maxGold;
    }

    public void backtrack(int[][] grid, int r, int c, int current)
    {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0)
        {
            return;
        }

        // choose
        int gold = grid[r][c];
        grid[r][c] = 0;
        current = current + gold;

        maxGold = Math.max(maxGold, current);

        // explore
        backtrack(grid, r + 1, c, current);
        backtrack(grid, r - 1, c, current);
        backtrack(grid, r, c + 1, current);
        backtrack(grid, r, c - 1, current);

        // unchoose
        grid[r][c] = gold;
        current = current - gold;
    }

    public static void main(String[] args)
    {
        _11PathWithMaximumGold obj = new _11PathWithMaximumGold();

        int[][] grid =
                {
                        {0, 6, 0},
                        {5, 8, 7},
                        {0, 9, 0}
                };

        System.out.println(obj.getMaximumGold(grid));
    }
}

/*
---------------- DRY RUN ----------------

grid =
[
 [0,6,0],
 [5,8,7],
 [0,9,0]
]

Start at (0,1) → 6
Path: 6 → 8 → 9 = 23
Path: 6 → 8 → 7 = 21

Start at (1,0) → 5
Path: 5 → 8 → 9 = 22

Start at (1,1) → 8
Path: 8 → 9 = 17

Maximum collected gold = 23

----------------------------------------
*/
