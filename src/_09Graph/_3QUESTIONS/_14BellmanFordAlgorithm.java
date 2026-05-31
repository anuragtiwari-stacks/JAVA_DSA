package _09Graph._3QUESTIONS;

import java.util.*;

// Bellman Ford Algorithm
//
// Used for:
// 1. Single Source Shortest Path
// 2. Negative Weight Edges
// 3. Detecting Negative Cycle
//
// Time Complexity  : O(V * E)
// Space Complexity : O(V)

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
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        // Relax all edges V - 1 times
        for (int i = 1; i <= V - 1; i++)
        {
            for (Edge e : edges)
            {
                int u = e.u;
                int v = e.v;
                int wt = e.wt;

                // Relaxation Condition

                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v])
                {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Step 3:
        // Negative Cycle Detection

        for (Edge e : edges)
        {
            int u = e.u;
            int v = e.v;
            int wt = e.wt;

            if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v])
            {
                System.out.println("Negative Cycle Detected");

                return;
            }
        }

        // Step 4:
        // Print shortest distances

        System.out.println("Shortest Distance From Source " + src);

        for (int i = 0; i < V; i++)
        {
            System.out.println(i + " -> " + dist[i]);
        }
    }

    public static void main(String[] args)
    {
        int V = 5;

        int src = 0;

        ArrayList<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 5));
        edges.add(new Edge(1, 2, 1));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(2, 4, 1));
        edges.add(new Edge(4, 3, -1));

        _14BellmanFordAlgorithm obj = new _14BellmanFordAlgorithm();

        obj.bellmanFord(V, edges, src);
    }
}