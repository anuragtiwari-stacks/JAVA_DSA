package _09Graph._2DFS;

public class _2NumberOfProvinces_DFS
{

    /*
        Input: isConnected matrix:

        Example:
        isConnected = [
            [1, 1, 0],
            [1, 1, 0],
            [0, 0, 1]
        ]

        Graph:
            0 — 1     2

        ➤ Province 1: {0, 1}
        ➤ Province 2: {2}

        ✅ Output: 2
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

    public static void dfs(int node, int[][] isConnected, boolean[] visited)
    {

        visited[node] = true;

        for (int j = 0; j < isConnected.length; j++)
        {
            if (isConnected[node][j] == 1 && !visited[j])
            {
                dfs(j, isConnected, visited);
            }
        }

    }

}

/*
🔍 Concept:

- Each city is a node in a graph.
- `isConnected[i][j] == 1` implies a direct connection between city i and j.
- DFS is used to explore all cities in a province.
- If a city is unvisited, start a DFS → this is one province.
- Each DFS call explores and marks all cities in that province.
- Total number of DFS calls = number of provinces.

🧠 Graph Intuition:

    0 — 1     2

- Cities 0 and 1 are connected → 1st province
- City 2 is isolated → 2nd province

✅ Output: 2
*/
