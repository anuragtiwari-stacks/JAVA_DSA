package _6Graph._1BFS;

import java.util.*;

public class _2NumberOfProvinces
{

    /*
        Input: isConnected matrix:

        Example 1:
        isConnected = [
            [1, 1, 0],
            [1, 1, 0],
            [0, 0, 1]
        ]

        Graph:
            0 — 1     2

        - City 0 is connected to City 1
        - City 2 is isolated

        ➤ There are 2 provinces:
          - Province 1: {0, 1}
          - Province 2: {2}

        Output: 2
    */

    public static void main(String[] args)
    {

        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        System.out.println("Number of Provinces: " + findCircleNum(isConnected));

    }

    public static int findCircleNum(int[][] isConnected)
    {

        int n = isConnected.length;  // isConnected.length = number of rows = n

        boolean[] visited = new boolean[n];

        int provinceCount = 0;

        for (int i = 0; i < n; i++)
        {
            if (!visited[i])
            {
                bfs(isConnected, visited, i);
                provinceCount++;
            }
        }

        return provinceCount;

    }

    public static void bfs(int[][] isConnected, boolean[] visited, int start)
    {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);

        while (!queue.isEmpty())
        {

            int city = queue.remove();

            visited[city] = true;

            for (int j = 0; j < isConnected.length; j++)
            {
                if (isConnected[city][j] == 1 && !visited[j])
                {
                    queue.add(j);
                }
            }

        }

    }

}

/*
    🔍 Logic Explanation:

    - Each city is a node in a graph.
    - isConnected[i][j] == 1 means there's a direct connection between city i and j.
    - A province is a group of connected cities (directly or indirectly).
    - We use BFS to traverse each group of connected cities.
    - Each BFS traversal represents one province.
    - The total number of BFS runs = total number of provinces.
*/
