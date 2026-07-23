package _09Graph._3QUESTIONS;

import java.util.*;

public class _12PrimsAlgorithm
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

    public int primsMST(int V, ArrayList<ArrayList<Pair>> adj)
    {
        boolean[] visited = new boolean[V];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));

        // node = 0, weight = 0
        pq.add(new Pair(0, 0));

        int mstSum = 0;

        while (!pq.isEmpty())
        {
            Pair cur = pq.remove();

            int node = cur.node;
            int wt = cur.weight;

            if (visited[node])
            {
                continue;
            }

            visited[node] = true;

            mstSum = mstSum + wt;

            for (Pair nei : adj.get(node))
            {
                if (!visited[nei.node])
                {
                    pq.add(new Pair(nei.node, nei.weight));
                }
            }
        }

        return mstSum;
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
        adj.get(1).add(new Pair(0, 2));

        adj.get(0).add(new Pair(3, 6));
        adj.get(3).add(new Pair(0, 6));

        adj.get(1).add(new Pair(2, 3));
        adj.get(2).add(new Pair(1, 3));

        adj.get(1).add(new Pair(3, 8));
        adj.get(3).add(new Pair(1, 8));

        adj.get(1).add(new Pair(4, 5));
        adj.get(4).add(new Pair(1, 5));

        adj.get(2).add(new Pair(4, 7));
        adj.get(4).add(new Pair(2, 7));

        _12PrimsAlgorithm obj = new _12PrimsAlgorithm();

        System.out.println(obj.primsMST(V, adj));
    }
}