package _09Graph._3QUESTIONS;

// Logic:
// 1. Directed graph me cycle detect karne ke liye BFS (Kahn’s Algorithm) use hota hai.
// 2. Har node ka indegree calculate karte hain (kitni edges aa rahi hain).
// 3. Jis node ka indegree 0 ho, use queue me daalte hain.
// 4. BFS me:
//    - queue se node nikaalte hain
//    - uske neighbors ka indegree -- karte hain
//    - agar kisi neighbor ka indegree 0 ho jaaye, queue me daal dete hain
// 5. Processed nodes count agar V se kam reh jaaye,
//    to matlab kuch nodes kabhi indegree 0 nahi bane → CYCLE exists.

import java.util.*;

public class _3CycleDetectionInDirectedGraph
{
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++)
        {
            for (int neighbor : adj.get(i))
            {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++)
        {
            if (indegree[i] == 0)
            {
                queue.add(i);
            }
        }

        int count = 0;

        while (!queue.isEmpty())
        {
            int node = queue.remove();
            count++;

            for (int neighbor : adj.get(node))
            {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0)
                {
                    queue.add(neighbor);
                }
            }
        }

        return count != V;
    }

    public static void main(String[] args)
    {
        int V = 4;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
        {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1);

        _3CycleDetectionInDirectedGraph obj = new _3CycleDetectionInDirectedGraph();

        System.out.println(obj.isCyclic(V, adj));
    }
}

/*
Dry Run (Cycle Present Case):

Graph edges:
0 → 1
1 → 2
2 → 3
3 → 1

Step 1: Indegree calculation

Initial indegree:
node : indegree
0 : 0
1 : 0
2 : 0
3 : 0

After processing edges:
0 → 1 → indegree[1] = 1
1 → 2 → indegree[2] = 1
2 → 3 → indegree[3] = 1
3 → 1 → indegree[1] = 2

Final indegree:
0 : 0
1 : 2
2 : 1
3 : 1

Step 2: Push indegree = 0 nodes into queue
Queue = [0]

Step 3: BFS processing

Process 0
count = 1
Neighbor: 1
indegree[1] = 2 → 1
Queue = []

Step 4: Queue becomes empty but count = 1 < V (4)

Conclusion:
Some nodes never reached indegree 0
Cycle exists → return true
*/
