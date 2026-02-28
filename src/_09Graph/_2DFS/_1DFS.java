package _09Graph._2DFS;

import java.util.*;

public class _1DFS
{
    /*
        🔗 Graph Used:

            0 -- 1
            |    |
            2    3
            |
            4

        📌 Edges:
            [0-1], [0-2], [1-3], [2-4]

        ✅ Expected DFS Output (starting from 0): 0 1 3 2 4
    */

    public static void main(String[] args)
    {
        int vertices = 5;

        // Create an adjacency list for the graph
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++)
        {
            graph.add(new ArrayList<>());
        }

        // Build the graph
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 4);

        boolean[] visited = new boolean[vertices];

        System.out.println("DFS traversal starting from node 0:");
        dfs(0, graph, visited);
    }

    public static void addEdge(List<List<Integer>> graph, int u, int v)
    {
        graph.get(u).add(v);
        graph.get(v).add(u); // Since the graph is undirected
    }

    public static void dfs(int node, List<List<Integer>> graph, boolean[] visited)
    {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : graph.get(node))
        {
            if (!visited[neighbor])
            {
                dfs(neighbor, graph, visited);
            }
        }
    }
}

/*
    🔍 Concept:

    - DFS (Depth-First Search) explores as far as possible along each branch before backtracking.
    - Implemented using recursion or a stack.
    - We mark each visited node to avoid cycles and infinite loops.
    - Suitable for exploring components, detecting cycles, or traversing trees/graphs.
    - In this example, we represent the graph using an adjacency list.
    - The graph is undirected: edge from u → v also means edge from v → u.
*/
