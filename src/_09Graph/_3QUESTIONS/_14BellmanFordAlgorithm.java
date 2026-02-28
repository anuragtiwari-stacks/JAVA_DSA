package _09Graph._3QUESTIONS;

// Logic:
// 1. Bellman–Ford single source shortest path nikalta hai.
// 2. Negative edges allowed hote hain.
// 3. Sab edges ko (V - 1) times relax karte hain.
// 4. Extra iteration me agar distance update ho jaaye,
//    to negative cycle exist karti hai.

import java.util.*;

public class _14BellmanFordAlgorithm
{
    static class Edge
    {
        int u;
        int v;
        int wt;

        Edge(int u, int v, int wt)
        {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    public void bellmanFord(int V, ArrayList<Edge> edges, int src)
    {
        int[] dist = new int[V];

        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;

        // Relax edges V-1 times
        for (int i = 1; i <= V - 1; i++)
        {
            for (Edge e : edges)
            {
                if (dist[e.u] != Integer.MAX_VALUE
                        && dist[e.u] + e.wt < dist[e.v])
                {
                    dist[e.v] = dist[e.u] + e.wt;
                }
            }
        }

        // Negative cycle check
        for (Edge e : edges)
        {
            if (dist[e.u] != Integer.MAX_VALUE
                    && dist[e.u] + e.wt < dist[e.v])
            {
                System.out.println("Negative cycle detected");
                return;
            }
        }

        // Print result
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++)
        {
            System.out.println("Node " + i + " -> " + dist[i]);
        }
    }

    public static void main(String[] args)
    {
        int V = 5;
        int src = 0;

        ArrayList<Edge> edges = new ArrayList<>();

        // edges[u, v, weight]
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(4, 3, -1));
        edges.add(new Edge(2, 4, 1));
        edges.add(new Edge(1, 2, 1));
        edges.add(new Edge(0, 1, 5));

        _14BellmanFordAlgorithm obj =
                new _14BellmanFordAlgorithm();

        obj.bellmanFord(V, edges, src);
    }
}
/*
Initial:
dist = [0, INF, INF, INF, INF]

Iteration 1:
0→1 (5)   → dist[1] = 5
1→3 (2)   → dist[3] = 7
1→2 (1)   → dist[2] = 6
2→4 (1)   → dist[4] = 7
4→3 (-1)  → dist[3] = 6

dist = [0, 5, 6, 6, 7]

Iteration 2:
No update

Iteration 3:
No update

Iteration 4:
No update

No negative cycle

Final distances:
0 -> 0
1 -> 5
2 -> 6
3 -> 6
4 -> 7
*/
