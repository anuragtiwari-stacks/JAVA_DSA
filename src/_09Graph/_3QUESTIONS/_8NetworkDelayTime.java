package _09Graph._3QUESTIONS;

// Logic:
// 1. Network ko weighted directed graph maan lo.
//    Edge: u → v with time w.
// 2. Source node k se signal start hota hai.
// 3. Dijkstra Algorithm use karte hain (min-heap / PriorityQueue).
// 4. Distance array maintain karte hain:
//    - initially sab INF
//    - source k = 0
// 5. Har step me minimum time wale node ko process karte hain
//    aur uske neighbors ko relax karte hain.
// 6. End me agar koi node unreachable (INF) ho → return -1
//    warna maximum distance hi answer hota hai.

import java.util.*;

// 743. Network Delay Time
public class _8NetworkDelayTime
{
    static class Pair
    {
        int node;
        int time;

        Pair(int node, int time)
        {
            this.node = node;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k)
    {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for (int[] t : times)
        {
            adj.get(t[0]).add(new Pair(t[1], t[2]));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time,b.time));

        dist[k] = 0;
        pq.add(new Pair(k, 0));

        while (!pq.isEmpty())
        {
            Pair curr = pq.remove();
            int node = curr.node;
            int currTime = curr.time;

            if (currTime > dist[node])
            {
                continue;
            }

            for (Pair nei : adj.get(node))
            {
                if (currTime + nei.time < dist[nei.node])
                {
                    dist[nei.node] = currTime + nei.time;
                    pq.add(new Pair(nei.node, dist[nei.node]));
                }
            }
        }

        int ans = 0;

        for (int i = 1; i <= n; i++)
        {
            if (dist[i] == Integer.MAX_VALUE)
            {
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }

    public static void main(String[] args)
    {
        _8NetworkDelayTime obj = new _8NetworkDelayTime();

        int[][] times =
                {
                        {2, 1, 1},
                        {2, 3, 1},
                        {3, 4, 1}
                };

        int n = 4;
        int k = 2;

        System.out.println(obj.networkDelayTime(times, n, k));
    }
}
