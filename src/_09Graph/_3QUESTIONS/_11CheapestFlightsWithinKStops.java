package _09Graph._3QUESTIONS;

import java.util.*;

public class _11CheapestFlightsWithinKStops
{
    static class Tuple
    {
        int node;
        int cost;
        int stops;

        Tuple(int node, int cost, int stops)
        {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)
    {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for (int[] f : flights)
        {
            adj.get(f[0]).add(new int[]{f[1], f[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(src, 0, 0));

        while (!q.isEmpty())
        {
            Tuple cur = q.remove();
            int node = cur.node;
            int cost = cur.cost;
            int stops = cur.stops;

            if (stops > k)
            {
                continue;
            }

            for (int[] nei : adj.get(node))
            {
                int nextNode = nei[0];
                int price = nei[1];

                if (cost + price < dist[nextNode])
                {
                    dist[nextNode] = cost + price;
                    q.add(new Tuple(nextNode, dist[nextNode], stops + 1));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public static void main(String[] args)
    {
        _11CheapestFlightsWithinKStops obj =
                new _11CheapestFlightsWithinKStops();

        int n = 4;
        int[][] flights =
                {
                        {0, 1, 100},
                        {1, 2, 100},
                        {2, 3, 100},
                        {0, 3, 500}
                };

        int src = 0, dst = 3, k = 1;

        System.out.println(obj.findCheapestPrice(n, flights, src, dst, k));
    }
}

/*
n = 4
flights:
0 → 1 (100)
1 → 2 (100)
2 → 3 (100)
0 → 3 (500)

src = 0 , dst = 3 , k = 1

--------------------------------
Initialization:
dist = [0, INF, INF, INF]
Queue = [(0, cost=0, stops=0)]

--------------------------------
Step 1: pop (0,0,0)

neighbors:
0 → 1 : cost = 100 < INF
dist[1] = 100
push (1,100,1)

0 → 3 : cost = 500 < INF
dist[3] = 500
push (3,500,1)

Queue = [(1,100,1),(3,500,1)]

--------------------------------
Step 2: pop (1,100,1)

stops = 1 ≤ k

1 → 2 : cost = 200 < INF
dist[2] = 200
push (2,200,2)

Queue = [(3,500,1),(2,200,2)]

--------------------------------
Step 3: pop (3,500,1)

Reached dst but we continue (BFS style)

--------------------------------
Step 4: pop (2,200,2)

stops = 2 > k
ignore

--------------------------------
End

dist = [0,100,200,500]

Answer = dist[3] = 500
*/
