package _09Graph._1BFS;

import java.util.*;

public class _3PathExistsInGraph
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

        for (int[] x : edges)
        {
            addEdge(graph, x[0], x[1]);
        }

        boolean[] visited = new boolean[vertex];

        boolean result = bfs(source, destination, graph, visited);

        System.out.println("Path exists from " + source + " to " + destination + ": " + result);

    }

    static void addEdge(List<List<Integer>> graph, int u, int v)
    {
        graph.get(u).add(v);
        graph.get(v).add(u); // because it's an undirected graph

        // If there's a connection from u to v, there's also a connection from v to u.
    }

    static boolean bfs(int start, int end, List<List<Integer>> graph, boolean[] visited)
    {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty())
        {

            int current = queue.remove();

            if (current == end)
            {
                return true;
            }

            for (int neighbor : graph.get(current))
            {
                if (!visited[neighbor])
                {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }

        }

        return false;

    }

}

/*
    🔍 Logic Explanation:

    - We build the graph using an adjacency list and the addEdge() method.
    - Since it's undirected, each edge is added both ways.
    - We use BFS starting from the source.
    - If we reach the destination during traversal, we return true.
    - If BFS ends and the destination was not reached, we return false.
*/
