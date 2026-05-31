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

// 1971. Find if Path Exists in Graph
public class _3PathExistsInGraph
{
    public static void main(String[] args)
    {
        int n = 6;

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

        boolean result = validPath(n, edges, source, destination);

        System.out.println(result);
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination)
    {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges)
        {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];

        bfs(graph, visited, source);

        if (visited[destination] == true)
        {
            return true;
        }

        return false;
    }

    private static void bfs(List<List<Integer>> graph, boolean[] visited, int start)
    {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);

        visited[start] = true;

        while (!queue.isEmpty())
        {
            int curr = queue.remove();

            for (int nei : graph.get(curr))
            {
                if (!visited[nei])
                {
                    visited[nei] = true;

                    queue.add(nei);
                }
            }
        }
    }
}