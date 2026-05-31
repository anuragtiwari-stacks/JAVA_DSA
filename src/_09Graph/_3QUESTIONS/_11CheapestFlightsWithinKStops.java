package _09Graph._3QUESTIONS;

import java.util.*;

// 787. Cheapest Flights Within K Stops

public class _11CheapestFlightsWithinKStops
{
    static class Pair
    {
        int node;
        int price;

        Pair(int node, int price)
        {
            this.node = node;
            this.price = price;
        }
    }

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

    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k)
    {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for (int[] f : flights)
        {
            adj.get(f[0]).add(new Pair(f[1], f[2]));
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

            for (Pair nei : adj.get(node))
            {
                int nextNode = nei.node;
                int price = nei.price;

                if (cost + price < dist[nextNode])
                {
                    dist[nextNode] = cost + price;

                    q.add(new Tuple(nextNode, dist[nextNode], stops + 1));
                }
            }
        }

        if (dist[dst] == Integer.MAX_VALUE)
        {
            return -1;
        }

        return dist[dst];
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

        int src = 0;
        int dst = 3;
        int k = 1;

        System.out.println(obj.findCheapestPrice(n, flights, src, dst, k));
    }
}