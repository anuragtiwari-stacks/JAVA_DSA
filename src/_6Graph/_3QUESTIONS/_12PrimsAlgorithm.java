package _6Graph._3QUESTIONS;

import java.util.*;

public class _12PrimsAlgorithm
{
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

    public int primsMST(int V, ArrayList<ArrayList<int[]>> adj)
    {
        boolean[] visited = new boolean[V];

        PriorityQueue<Triplet> pq =
                new PriorityQueue<>((a, b) -> a.weight - b.weight);

        // start from node 0, parent = -1
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

            for (int[] nei : adj.get(node))
            {
                int nextNode = nei[0];
                int nextWt = nei[1];

                if (!visited[nextNode])
                {
                    pq.add(new Triplet(nextNode, node, nextWt));
                }
            }
        }

        return mstSum;
    }

    public static void main(String[] args)
    {
        int V = 5;

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
        {
            adj.add(new ArrayList<>());
        }

        // Undirected weighted graph
        adj.get(0).add(new int[]{1, 2});
        adj.get(1).add(new int[]{0, 2});

        adj.get(0).add(new int[]{3, 6});
        adj.get(3).add(new int[]{0, 6});

        adj.get(1).add(new int[]{2, 3});
        adj.get(2).add(new int[]{1, 3});

        adj.get(1).add(new int[]{3, 8});
        adj.get(3).add(new int[]{1, 8});

        adj.get(1).add(new int[]{4, 5});
        adj.get(4).add(new int[]{1, 5});

        adj.get(2).add(new int[]{4, 7});
        adj.get(4).add(new int[]{2, 7});

        _12PrimsAlgorithm obj = new _12PrimsAlgorithm();

        int ans = obj.primsMST(V, adj);

        System.out.println("MST Total Weight = " + ans);
    }
}

/*
Heap stores (node, parent, weight)

Initial:
PQ = [(0, -1, 0)]
visited = [F,F,F,F,F]
mstSum = 0

Step 1:
pop (0,-1,0)
visit 0
push (1,0,2), (3,0,6)

Step 2:
pop (1,0,2)
visit 1
MST edge: 0 - 1 (2)
push (2,1,3), (3,1,8), (4,1,5)

Step 3:
pop (2,1,3)
visit 2
MST edge: 1 - 2 (3)
push (4,2,7)

Step 4:
pop (4,1,5)
visit 4
MST edge: 1 - 4 (5)

Step 5:
pop (3,0,6)
visit 3
MST edge: 0 - 3 (6)

Final MST edges:
0-1, 1-2, 1-4, 0-3

Total Weight = 16
*/
