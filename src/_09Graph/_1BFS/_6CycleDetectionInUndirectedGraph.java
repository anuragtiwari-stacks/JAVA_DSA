package _09Graph._1BFS;

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
                if (bfs(i, adj, visited))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited)
    {
        Queue<int[]> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(new int[]{start, -1});

        while (!queue.isEmpty())
        {
            int[] pair = queue.remove();
            int node = pair[0];
            int parent = pair[1];

            for (int neighbor : adj.get(node))
            {
                if (!visited[neighbor])
                {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, node});
                }
                else if (neighbor != parent)
                {
                    return true;
                }
            }
        }
        return false;
    }
}

/*
Dry Run:

V = 4
Edges:
0 - 1
1 - 2
2 - 3
3 - 1

visited = [false, false, false, false]

Start BFS from node 0
Queue = [(0, -1)]
visited = [true, false, false, false]

Process node 0
Neighbor = 1 → mark visited
Queue = [(1, 0)]

Process node 1
Neighbors = 0, 2, 3
0 is parent → ignore
2 not visited → add (2,1)
3 not visited → add (3,1)

Queue = [(2,1), (3,1)]

Process node 2
Neighbors = 1, 3
1 is parent → ignore
3 is visited and not parent → cycle detected

Return true
*/
