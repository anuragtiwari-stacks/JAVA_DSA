package _6Graph._3QUESTIONS;

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

/*
Dry Run:

n = 3
edges:
0 --0.5-- 1
1 --0.5-- 2
0 --0.2-- 2

start = 0, end = 2

Initial:
prob = [1.0, 0.0, 0.0]
PQ = [(0, 1.0)]

Step 1:
Remove (0, 1.0)
Neighbors:
1: 1.0 * 0.5 = 0.5 > 0 → prob[1]=0.5 → push (1,0.5)
2: 1.0 * 0.2 = 0.2 > 0 → prob[2]=0.2 → push (2,0.2)

PQ = [(1,0.5), (2,0.2)]

Step 2:
Remove (1, 0.5)
Neighbors:
0: 0.5 * 0.5 = 0.25 < 1.0 → ignore
2: 0.5 * 0.5 = 0.25 > 0.2 → prob[2]=0.25 → push (2,0.25)

PQ = [(2,0.25), (2,0.2)]

Step 3:
Remove (2, 0.25)
node == end → return 0.25

Final Answer:
0.25
*/
