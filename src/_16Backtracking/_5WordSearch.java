package _16Backtracking;

// LeetCode 79: Word Search
import java.util.*;

public class _5WordSearch
{
    public boolean exist(char[][] board, String word)
    {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == word.charAt(0))
                {
                    if (find(board, word, i, j, 0))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    // DFS + backtracking
    public boolean find(char[][] board, String word, int row, int col, int idx)
    {
        if (idx == word.length())
        {
            return true;
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length)
        {
            return false;
        }

        if (board[row][col] != word.charAt(idx))
        {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#';   // mark visited

        boolean found =
                find(board, word, row + 1, col, idx + 1) ||
                        find(board, word, row - 1, col, idx + 1) ||
                        find(board, word, row, col + 1, idx + 1) ||
                        find(board, word, row, col - 1, idx + 1);

        board[row][col] = temp;  // backtrack

        return found;
    }

    public static void main(String[] args)
    {
        _5WordSearch obj = new _5WordSearch();

        char[][] board =
                {
                        {'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}
                };

        String word = "ABCCED";

        System.out.println(obj.exist(board, word));
    }
}

/*
---------------- DRY RUN ----------------

Board:
A B C E
S F C S
A D E E

Word = "ABCCED"

Start at (0,0) = 'A'
→ move right to 'B'
→ move right to 'C'
→ move down to 'C'
→ move down to 'E'
→ move left to 'D'

All characters matched in order
idx == word.length() → true

----------------------------------------
*/
