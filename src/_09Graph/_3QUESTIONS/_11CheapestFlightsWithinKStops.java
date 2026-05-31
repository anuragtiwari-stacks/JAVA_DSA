package _09Graph._3QUESTIONS;

import java.util.*;

// 787. Cheapest Flights Within K Stops

public class _11CheapestFlightsWithinKStops
{
    static class Node
    {
        int node;
        int cost;
        int stops;

        Node(int node, int cost, int stops)
        {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)
    {
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for (int[] f : flights)
        {
            adj.get(f[0]).add(new Node(f[1], f[2], 0));
        }

        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        Queue<Node> q = new LinkedList<>();

        q.add(new Node(src, 0, 0));

        while (!q.isEmpty())
        {
            Node cur = q.remove();

            int node = cur.node;
            int cost = cur.cost;
            int stops = cur.stops;

            if (stops > k)
            {
                continue;
            }

            for (Node nei : adj.get(node))
            {
                int nextNode = nei.node;
                int newCost = cost + nei.cost;

                if (newCost < dist[nextNode])
                {
                    dist[nextNode] = newCost;

                    q.add(new Node(nextNode, newCost, stops + 1));
                }
            }
        }


        if(dist[dst]==Integer.MAX_VALUE)
        {
            return -1;
        }

        return dist[dst];
    }

    public static void main(String[] args)
    {
        _11CheapestFlightsWithinKStops obj = new _11CheapestFlightsWithinKStops();

        int n = 4;

        int[][] flights = {
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