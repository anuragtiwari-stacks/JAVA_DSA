package _19BackTracking;

// LeetCode 79: Word Search

public class _5WordSearch
{
    public boolean exist(char[][] board, String word)
    {
        int r = board.length;
        int c = board[0].length;

        boolean[][] visited = new boolean[r][c];

        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    if(WordSearch(board, visited, word, i, j, 0))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean WordSearch(char[][] board, boolean[][] visited, String word, int r, int c, int idx)
    {
        if(idx == word.length() - 1)
        {
            return true;
        }

        visited[r][c] = true;

        // Up
        if(r - 1 >= 0)
        {
            if(board[r - 1][c] == word.charAt(idx + 1) && !visited[r - 1][c])
            {
                if(WordSearch(board, visited, word,
                        r - 1, c, idx + 1))
                {
                    return true;
                }
            }
        }

        // Down
        if(r + 1 < board.length)
        {
            if(board[r + 1][c] == word.charAt(idx + 1) && !visited[r + 1][c])
            {
                if(WordSearch(board, visited, word,
                        r + 1, c, idx + 1))
                {
                    return true;
                }
            }
        }

        // Left
        if(c - 1 >= 0)
        {
            if(board[r][c - 1] == word.charAt(idx + 1) && !visited[r][c - 1])
            {
                if(WordSearch(board, visited, word,
                        r, c - 1, idx + 1))
                {
                    return true;
                }
            }
        }

        // Right
        if(c + 1 < board[0].length)
        {
            if(board[r][c + 1] == word.charAt(idx + 1)  && !visited[r][c + 1])
            {
                if(WordSearch(board, visited, word,
                        r, c + 1, idx + 1))
                {
                    return true;
                }
            }
        }

        visited[r][c] = false; // backtracking

        return false;
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