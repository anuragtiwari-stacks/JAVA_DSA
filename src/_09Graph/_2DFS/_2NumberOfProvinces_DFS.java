package _09Graph._2DFS;

import java.util.*;

// Number Of Provinces Using DFS

public class _2NumberOfProvinces_DFS
{

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

        int n = isConnected.length;

        boolean[] visited = new boolean[n];

        int provinceCount = 0;

        for (int i = 0; i < n; i++)
        {

            if (!visited[i])
            {

                dfs(i, isConnected, visited);

                provinceCount++;

            }

        }

        return provinceCount;

    }

    public static void dfs(int start, int[][] isConnected, boolean[] visited)
    {

        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        visited[start] = true;

        while (!stack.isEmpty())
        {

            int node = stack.pop();

            for (int j = 0; j < isConnected.length; j++)
            {

                if (isConnected[node][j] == 1 && !visited[j])
                {

                    stack.push(j);

                    visited[j] = true;

                }

            }

        }

    }

}