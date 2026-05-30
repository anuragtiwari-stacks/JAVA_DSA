package _09Graph._2DFS;

import java.util.*;

public class _6CycleDetectionInUndirectedGraph
{
    public static void main(String[] args)
    {
        int V = 4;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
        {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 1);

        System.out.println("Graph : " + adj);

        _6CycleDetectionInUndirectedGraph obj = new _6CycleDetectionInUndirectedGraph();

        boolean result = obj.isCycle(V, adj);

        System.out.println("Cycle Present : " + result);
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++)
        {
            if (!visited[i])
            {
                if (dfs(i, -1, adj, visited))
                {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited)
    {
        visited[node] = true;

        for (int neighbor : adj.get(node))
        {
            if (!visited[neighbor])
            {
                if (dfs(neighbor, node, adj, visited))
                {
                    return true;
                }
            }
            else if (neighbor != parent)
            {
                return true;
            }
        }

        return false;
    }
}