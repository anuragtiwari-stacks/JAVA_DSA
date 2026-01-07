package _6Graph._3QUESTIONS;

// Logic:
// 1. Dijkstra algorithm weighted graph me shortest path find karta hai
//    (sirf NON-NEGATIVE weights ke liye).
// 2. Distance array maintain karte hain, initially sab INF, source = 0.
// 3. Min-heap (PriorityQueue) use karte hain jisse minimum distance wala
//    node pehle mile.
// 4. Har node ke neighbors ke liye:
//    agar (currentDist + edgeWeight < neighborDist)
//    to distance update kar do aur PQ me daal do.
// 5. Jab PQ empty ho jaaye, distance array me final shortest distances mil jaati hain.

import java.util.*;

public class _7DijkstraAlgorithm
{
    static class Pair
    {
        int node;
        int dist;

        Pair(int node, int dist)
        {
            this.node = node;
            this.dist = dist;
        }
    }

    public int[] dijkstra(int V, ArrayList<ArrayList<Pair>> adj, int src)
    {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.dist - b.dist);

        dist[src] = 0;
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty())
        {
            Pair curr = pq.remove();
            int node = curr.node;
            int currDist = curr.dist;

            if (currDist > dist[node])
            {
                continue;
            }

            for (Pair neighbor : adj.get(node))
            {
                int nextNode = neighbor.node;
                int weight = neighbor.dist;

                if (currDist + weight < dist[nextNode])
                {
                    dist[nextNode] = currDist + weight;
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

        int[] result = obj.dijkstra(V, adj, 0);

        for (int i = 0; i < V; i++)
        {
            System.out.println("Distance from 0 to " + i + " = " + result[i]);
        }
    }
}

/*
Dry Run:

Graph edges:
0 → 1 (2)
0 → 4 (1)
1 → 2 (3)
1 → 3 (8)
1 → 4 (2)
2 → 3 (1)
4 → 3 (5)

Source = 0

Initial:
dist = [0, INF, INF, INF, INF]
PQ = [(0,0)]

Step 1:
Remove (0,0)
Check neighbors:
1: 0+2 < INF → dist[1]=2
4: 0+1 < INF → dist[4]=1
PQ = [(4,1), (1,2)]

Step 2:
Remove (4,1)
Check neighbor:
3: 1+5 = 6 < INF → dist[3]=6
PQ = [(1,2), (3,6)]

Step 3:
Remove (1,2)
Check neighbors:
2: 2+3 = 5 < INF → dist[2]=5
3: 2+8 = 10 > 6 → ignore
4: 2+2 = 4 > 1 → ignore
PQ = [(2,5), (3,6)]

Step 4:
Remove (2,5)
Check neighbor:
3: 5+1 = 6 == 6 → no change
PQ = [(3,6)]

Step 5:
Remove (3,6)
No neighbors

Final distances:
0 → 0
1 → 2
2 → 5
3 → 6
4 → 1
*/
