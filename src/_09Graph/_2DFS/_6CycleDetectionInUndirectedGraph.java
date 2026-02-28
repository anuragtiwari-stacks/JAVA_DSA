package _09Graph._2DFS;

import java.util.*;

public class _6CycleDetectionInUndirectedGraph
{
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

    public static void main(String[] args)
    {
        int V = 4;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
        {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(1);
        adj.get(1).add(3);

        _6CycleDetectionInUndirectedGraph obj = new _6CycleDetectionInUndirectedGraph();

        System.out.println(obj.isCycle(V, adj));
    }
}

/*
Dry Run (0-1-2-3 cycle):

Start DFS from 0
dfs(0, -1)
 visited[0] = true

Neighbor 1 → not visited
dfs(1, 0)
 visited[1] = true

Neighbors: 0, 2, 3
0 == parent → ignore

Neighbor 2 → not visited
dfs(2, 1)
 visited[2] = true

Neighbors: 1, 3
1 == parent → ignore

Neighbor 3 → not visited
dfs(3, 2)
 visited[3] = true

Neighbors: 2, 1
2 == parent → ignore
1 is visited AND 1 != parent(2)
Cycle detected → return true

Final Output:
true
*/
