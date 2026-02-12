package _19BackTracking;

// LeetCode 37: Sudoku Solver
import java.util.*;

public class _4SudokuSolver
{
    public void solveSudoku(char[][] board)
    {
        solve(board);
    }

    // backtracking to fill empty cells
    public boolean solve(char[][] board)
    {
        for (int row = 0; row < 9; row++)
        {
            for (int col = 0; col < 9; col++)
            {
                if (board[row][col] == '.')
                {
                    for (char num = '1'; num <= '9'; num++)
                    {
                        if (isSafe(board, row, col, num))
                        {
                            board[row][col] = num;   // choose

                            if (solve(board))       // explore
                            {
                                return true;
                            }

                            board[row][col] = '.';  // unchoose
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    // check row, column and 3x3 box
    public boolean isSafe(char[][] board, int row, int col, char num)
    {
        for (int j = 0; j < 9; j++)
        {
            if (board[row][j] == num)
            {
                return false;
            }
        }

        for (int i = 0; i < 9; i++)
        {
            if (board[i][col] == num)
            {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++)
        {
            for (int j = startCol; j < startCol + 3; j++)
            {
                if (board[i][j] == num)
                {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args)
    {
        _4SudokuSolver obj = new _4SudokuSolver();

        char[][] board =
                {
                        {'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}
                };

        obj.solveSudoku(board);

        for (char[] row : board)
        {
            System.out.println(Arrays.toString(row));
        }
    }
}

/*
---------------- DRY RUN ----------------

Empty cell found at (0,2)

Try numbers 1–9:
1 → safe → place
Move to next empty cell

If later conflict occurs:
Backtrack → reset cell to '.'
Try next number

Process continues until all cells are filled

Final board becomes a valid Sudoku solution

----------------------------------------
*/
