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

    static class Triplet
    {
        int node;
        int parent;
        int weight;

        Triplet(int node, int parent, int weight)
        {
            this.node = node;
            this.parent = parent;
            this.weight = weight;
        }
    }

    public int primsMST(int V, ArrayList<ArrayList<Pair>> adj)
    {
        boolean[] visited = new boolean[V];

        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));

        pq.add(new Triplet(0, -1, 0));

        int mstSum = 0;

        while (!pq.isEmpty())
        {
            Triplet cur = pq.remove();

            int node = cur.node;
            int parent = cur.parent;
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
                    int nextNode = nei.node;
                    int nextWeight = nei.weight;
                    pq.add(new Triplet(nextNode, node, nextWeight));
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

        // Undirected weighted graph
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

        int ans = obj.primsMST(V, adj);

        System.out.println("MST Total Weight = " + ans);
    }
}