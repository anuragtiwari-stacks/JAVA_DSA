package _09Graph._3QUESTIONS;

import java.util.*;

public class _7DijkstraAlgorithm
{
    static class Pair
    {
        int node;
        int weight;

        Pair(int node, int weight)
        {
            this.node = node;
            this.weight = weight;
        }
    }

    public int[] dijkstra(int V, ArrayList<ArrayList<Pair>> adj, int src)
    {
        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        dist[src] = 0;

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty())
        {
            Pair curr = pq.remove();

            int node = curr.node;
            int currWeight = curr.weight;

            for (Pair neighbor : adj.get(node))
            {
                int nextNode = neighbor.node;
                int edgeWeight = neighbor.weight;

                if (currWeight + edgeWeight < dist[nextNode])
                {
                    dist[nextNode] = currWeight + edgeWeight;

                    pq.add(new Pair(nextNode, dist[nextNode]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args)
    {
        int V = 5;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
        {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(4, 1));

        adj.get(1).add(new Pair(2, 3));
        adj.get(1).add(new Pair(3, 8));
        adj.get(1).add(new Pair(4, 2));

        adj.get(2).add(new Pair(3, 1));

        adj.get(4).add(new Pair(3, 5));

        _7DijkstraAlgorithm obj = new _7DijkstraAlgorithm();

        int[] ans = obj.dijkstra(V, adj, 0);

        for (int i = 0; i < V; i++)
        {
            System.out.println(ans[i]);
        }
    }
}