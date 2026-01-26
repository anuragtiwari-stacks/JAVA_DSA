package _16Backtracking;

// LeetCode 51: N-Queens
import java.util.*;

public class _3NQueens
{
    public List<List<String>> solveNQueens(int n)
    {
        List<List<String>> ans = new ArrayList<>();

        // chess board initialization
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                board[i][j] = '.';
            }
        }

        solve(0, board, ans, n);
        return ans;
    }

    // place queens row by row
    public void solve(int row, char[][] board, List<List<String>> ans, int n)
    {
        // all rows filled -> valid configuration
        if (row == n)
        {
            ans.add(build(board));
            return;
        }

        for (int col = 0; col < n; col++)
        {
            if (isSafe(row, col, board, n))
            {
                board[row][col] = 'Q';   // choose
                solve(row + 1, board, ans, n); // explore
                board[row][col] = '.';   // unchoose
            }
        }
    }

    // check column and diagonals
    public boolean isSafe(int row, int col, char[][] board, int n)
    {
        // same column
        for (int i = 0; i < row; i++)
        {
            if (board[i][col] == 'Q')
            {
                return false;
            }
        }

        // upper-left diagonal
        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0)
        {
            if (board[i][j] == 'Q')
            {
                return false;
            }
            i--;
            j--;
        }

        // upper-right diagonal
        int i2 = row - 1;
        int j2 = col + 1;
        while (i2 >= 0 && j2 < n)
        {
            if (board[i2][j2] == 'Q')
            {
                return false;
            }
            i2--;
            j2++;
        }

        return true;
    }

    // convert board to required output format
    public List<String> build(char[][] board)
    {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < board.length; i++)
        {
            res.add(new String(board[i]));
        }

        return res;
    }

    public static void main(String[] args)
    {
        _3NQueens obj = new _3NQueens();

        int n = 4;
        System.out.println(obj.solveNQueens(n));
    }
}

/*
---------------- DRY RUN ----------------

n = 4

Row 0:
Place Q at col 1

Row 1:
Place Q at col 3

Row 2:
Place Q at col 0

Row 3:
Place Q at col 2
→ one valid board stored

Backtracking continues to find second solution

Final Output:
[
 [".Q..","...Q","Q...","..Q."],
 ["..Q.","Q...","...Q",".Q.."]
]

----------------------------------------
*/
