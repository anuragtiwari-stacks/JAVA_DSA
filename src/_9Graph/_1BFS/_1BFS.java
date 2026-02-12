package _9Graph._1BFS;

import java.util.*;

public class _1BFS
{

    /*
        Graph structure (Undirected):

            0
           / \
          1   2
         /     \
        3       4

        Edges:
        0 - 1
        0 - 2
        1 - 3
        2 - 4

        Expected BFS traversal from node 0:
        0 1 2 3 4
    */

    public static void main(String[] args)
    {

        int vertex = 5;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertex; i++)
        {
            graph.add(new ArrayList<>());
        }

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 4);

        boolean[] visited = new boolean[vertex];

        System.out.println("BFS traversal from node 0:");
        bfs(0, graph, visited);

    }

    static void addEdge(List<List<Integer>> graph, int u, int v)
    {
        graph.get(u).add(v);
        graph.get(v).add(u); // because it's an undirected graph

        // If there's a connection from 0 to 1, there's also a connection from 1 to 0.
    }

    static void bfs(int start, List<List<Integer>> graph, boolean[] visited)
    {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty())
        {

            int current = queue.remove();
            System.out.print(current + " ");

            for (int x : graph.get(current))
            {
                if (!visited[x])
                {
                    queue.add(x);
                    visited[x] = true;
                }
            }

        }

    }

}

/*
    🔍 Logic Explanation:

    - We represent the graph using an adjacency list (List of Lists).
    - We create edges using addEdge(), which adds connections in both directions (undirected).
    - BFS starts from a given node and explores neighbors level by level.
    - A queue is used to manage the order of traversal.
    - A visited[] array tracks which nodes we've already visited to avoid loops.
    - This ensures all reachable nodes are visited in the correct BFS order.
*/
