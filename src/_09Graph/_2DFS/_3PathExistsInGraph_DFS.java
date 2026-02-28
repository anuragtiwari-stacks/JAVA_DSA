package _09Graph._2DFS;

import java.util.*;

public class _3PathExistsInGraph_DFS
{

    /*
        🔗 Input:
        n = 6
        edges = [[0,1],[0,2],[3,5],[5,4],[4,3]]
        source = 0
        destination = 5

        🔍 Graph (Undirected):

        0 → [1, 2]
        1 → [0]
        2 → [0]
        3 → [5, 4]
        4 → [5, 3]
        5 → [3, 4]

        ⛔ No path exists from 0 to 5
    */

    public static void main(String[] args)
    {

        int vertex = 6;

        int[][] edges = {
                {0, 1},
                {0, 2},
                {3, 5},
                {5, 4},
                {4, 3}
        };

        int source = 0;
        int destination = 5;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertex; i++)
        {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges)
        {
            addEdge(graph, edge[0], edge[1]);
        }

        boolean[] visited = new boolean[vertex];

        boolean result = dfs(source, destination, graph, visited);

        System.out.println("Path exists from " + source + " to " + destination + ": " + result);

    }

    static void addEdge(List<List<Integer>> graph, int u, int v)
    {
        graph.get(u).add(v);
        graph.get(v).add(u); // undirected graph
    }

    static boolean dfs(int current, int target, List<List<Integer>> graph, boolean[] visited)
    {

        if (current == target)
        {
            return true;
        }

        visited[current] = true;

        for (int neighbor : graph.get(current))
        {
            if (!visited[neighbor])
            {
                if (dfs(neighbor, target, graph, visited))
                {
                    return true;
                }
            }
        }

        return false;

    }

}

/*
    🔍 Concept:

    - The graph is built using an adjacency list and undirected edges.
    - We use DFS to explore from the `source` node.
    - If during recursion we reach the `destination`, we return true.
    - We mark visited nodes to avoid cycles or re-visiting.
    - If DFS finishes without reaching the destination, return false.

    🧠 Intuition:

        0 — 1     3 — 5
         \         /
          2       4

    - There is no path connecting component {0,1,2} to {3,4,5}.
    - Hence, DFS starting from 0 can never reach 5.

    ✅ Output: false
*/
