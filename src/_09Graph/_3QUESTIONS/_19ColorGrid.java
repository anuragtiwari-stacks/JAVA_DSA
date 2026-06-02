package _09Graph._3QUESTIONS;

import java.util.*;

public class _19ColorGrid
{
    static class Pair
    {
        int row;
        int col;
        int color;

        Pair(int row, int col, int color)
        {
            this.row = row;
            this.col = col;
            this.color = color;
        }
    }

    public static int[][] colorGrid(int n, int m, int[][] sources)
    {
        int[][] grid = new int[n][m];

        boolean[][] visited = new boolean[n][m];

        Queue<Pair> q = new LinkedList<>();

        // Sort sources by descending color

        Arrays.sort(sources,(a, b) -> Integer.compare(b[2], a[2]));

        for(int i = 0; i < sources.length; i++)
        {
            int row = sources[i][0];
            int col = sources[i][1];
            int color = sources[i][2];

            grid[row][col] = color;
            visited[row][col] = true;

            q.offer(new Pair(row, col, color));
        }

        // BFS

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i = 0; i < size; i++)
            {
                Pair current = q.poll();

                int row = current.row;
                int col = current.col;
                int color = current.color;

                // TOP

                if(row - 1 >= 0 && !visited[row - 1][col])
                {
                    visited[row - 1][col] = true;
                    grid[row - 1][col] = color;

                    q.offer(new Pair(row - 1, col, color));
                }

                // RIGHT

                if(col + 1 < m && !visited[row][col + 1])
                {
                    visited[row][col + 1] = true;
                    grid[row][col + 1] = color;

                    q.offer(new Pair(row, col + 1, color));
                }

                // BOTTOM

                if(row + 1 < n && !visited[row + 1][col])
                {
                    visited[row + 1][col] = true;
                    grid[row + 1][col] = color;

                    q.offer(new Pair(row + 1, col, color));
                }

                // LEFT

                if(col - 1 >= 0 && !visited[row][col - 1])
                {
                    visited[row][col - 1] = true;
                    grid[row][col - 1] = color;

                    q.offer(new Pair(row, col - 1, color));
                }
            }
        }

        return grid;
    }

    public static void main(String[] args)
    {
        int n = 5;
        int m = 5;

        int[][] sources =
                {
                        {0, 0, 1},
                        {4, 4, 9},
                        {2, 2, 5}
                };

        int[][] ans = colorGrid(n, m, sources);

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                System.out.print(ans[i][j] + " ");
            }

            System.out.println();
        }
    }
}