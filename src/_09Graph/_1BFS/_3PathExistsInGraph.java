package _09Graph._1BFS;


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

import java.util.*;

public class _3PathExistsInGraph
{
    public static void main(String[] args)
    {
        int vertex = 6;

        int[][] edges =
                {
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

        System.out.println("Graph : " + graph);

        boolean[] visited = new boolean[vertex];

        boolean result = bfs(source, destination, graph, visited);

        System.out.println("\nPath exists from "
                + source + " to "
                + destination + " : "
                + result);
    }

    static void addEdge(List<List<Integer>> graph, int u, int v)
    {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    static boolean bfs(int start, int end, List<List<Integer>> graph, boolean[] visited)
    {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);

        visited[start] = true;

        System.out.print("BFS Traversal : ");

        while (!queue.isEmpty())
        {
            int current = queue.remove();

            System.out.print(current + " ");

            if (current == end)
            {
                return true;
            }

            for (int neighbor : graph.get(current))
            {
                if (!visited[neighbor])
                {
                    visited[neighbor] = true;

                    queue.add(neighbor);
                }
            }
        }

        return false;
    }
}