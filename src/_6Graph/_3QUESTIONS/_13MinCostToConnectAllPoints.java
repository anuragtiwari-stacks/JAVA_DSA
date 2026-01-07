package _6Graph._3QUESTIONS;

// Logic:
// 1. Har point ek node hai.
// 2. Har point har doosre point se connect ho sakta hai
//    (implicit complete graph).
// 3. Edge weight = Manhattan distance:
//    |x1 - x2| + |y1 - y2|
// 4. Prim’s Algorithm use karte hain:
//    - heap me (node, parent, weight)
//    - visited array se MST track
// 5. Jab saare nodes visit ho jaayein → MST complete.

import java.util.*;

public class _13MinCostToConnectAllPoints
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

    public int minCostConnectPoints(int[][] points)
    {
        int n = points.length;

        boolean[] visited = new boolean[n];

        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        // start from node 0
        pq.add(new Triplet(0, -1, 0));

        int totalCost = 0;

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
            totalCost = totalCost + wt;

            // connect current node to all unvisited points
            for (int i = 0; i < n; i++)
            {
                if (!visited[i])
                {
                    int dist = Math.abs(points[node][0] - points[i][0]) + Math.abs(points[node][1] - points[i][1]);

                    pq.add(new Triplet(i, node, dist));
                }
            }
        }

        return totalCost;
    }

    public static void main(String[] args)
    {
        _13MinCostToConnectAllPoints obj = new _13MinCostToConnectAllPoints();

        int[][] points =
                {
                        {0, 0},
                        {2, 2},
                        {3, 10},
                        {5, 2},
                        {7, 0}
                };

        int ans = obj.minCostConnectPoints(points);

        System.out.println("Total Minimum Cost = " + ans);
    }
}
/*
Points:
0:(0,0)
1:(2,2)
2:(3,10)
3:(5,2)
4:(7,0)

--------------------------------
Initial:
PQ = [(0,-1,0)]
visited = [F,F,F,F,F]
totalCost = 0

--------------------------------
Step 1:
pop (0,-1,0)
visit 0
totalCost = totalCost + 0 = 0

push edges:
0-1(4), 0-2(13), 0-3(7), 0-4(7)

--------------------------------
Step 2:
pop (1,0,4)
visit 1
MST edge: 0-1 (4)
totalCost = totalCost + 4 = 4

push:
1-2(9), 1-3(3), 1-4(7)

--------------------------------
Step 3:
pop (3,1,3)
visit 3
MST edge: 1-3 (3)
totalCost = totalCost + 3 = 7

push:
3-2(10), 3-4(4)

--------------------------------
Step 4:
pop (4,3,4)
visit 4
MST edge: 3-4 (4)
totalCost = totalCost + 4 = 11

--------------------------------
Step 5:
pop (2,1,9)
visit 2
MST edge: 1-2 (9)
totalCost = totalCost + 9 = 20

--------------------------------
All nodes visited

Final MST Edges:
0-1, 1-3, 3-4, 1-2

Final Total Cost = 20
*/
