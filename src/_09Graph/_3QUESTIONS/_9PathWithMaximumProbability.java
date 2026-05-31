package _09Graph._3QUESTIONS;

// Logic:
// 1. Graph ko weighted graph maan lo, jahan weight = probability.
// 2. Hume start se end tak ka aisa path chahiye jiska
//    total probability MAX ho.
// 3. Ye Dijkstra jaisa hi hai, bas:
//    - sum ki jagah MULTIPLY
//    - min-heap ki jagah MAX-heap (PriorityQueue)
// 4. Probability array maintain karte hain:
//    - initially sab 0
//    - start node = 1.0
// 5. Har step me max probability wale node ko process karte hain.
// 6. Agar end node mil jaaye, wahi maximum probability hogi.

import java.util.*;

// 1514. Path with Maximum Probability
public class _9PathWithMaximumProbability
{
    static class Pair
    {
        int node;
        double prob;

        Pair(int node, double prob)
        {
            this.node = node;
            this.prob = prob;
        }
    }

    public double maxProbability(
            int n,
            int[][] edges,
            double[] succProb,
            int start,
            int end
    )
    {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];

            adj.get(u).add(new Pair(v, p));
            adj.get(v).add(new Pair(u, p));
        }

        double[] prob = new double[n];
        prob[start] = 1.0;

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) ->
                        Double.compare(b.prob, a.prob));

        pq.add(new Pair(start, 1.0));

        while (!pq.isEmpty())
        {
            Pair curr = pq.remove();
            int node = curr.node;
            double currProb = curr.prob;

            if (node == end)
            {
                return currProb;
            }

            if (currProb < prob[node])
            {
                continue;
            }

            for (Pair nei : adj.get(node))
            {
                double newProb = currProb * nei.prob;

                if (newProb > prob[nei.node])
                {
                    prob[nei.node] = newProb;
                    pq.add(new Pair(nei.node, newProb));
                }
            }
        }

        return 0.0;
    }

    public static void main(String[] args)
    {
        _9PathWithMaximumProbability obj =
                new _9PathWithMaximumProbability();

        int n = 3;
        int[][] edges =
                {
                        {0, 1},
                        {1, 2},
                        {0, 2}
                };

        double[] succProb =
                {
                        0.5,
                        0.5,
                        0.2
                };

        int start = 0;
        int end = 2;

        System.out.println(obj.maxProbability(
                n, edges, succProb, start, end));
    }
}
